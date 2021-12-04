package com.wkk.simulation.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 区间、二分均可
 * @author weikunkun
 * @since 2021/6/9
 */
public class 最优分割 {
    public static void main(String[] args) {
        // 第一类区间DP
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int group = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(cal(arr, len, group));
    }

    private static int cal(int[] array, int len, int group) {
        // 前i个个元素分为j组 所有组中权重最大的最小值
        // dp[i][j] = Math.min(dp[l][j-1], MaxSum s[l:i]);
        // dp[len - 1][group];
        int[] preSum = genPreSum(array, len);
        int[][] dp = new int[len + 1][group + 1];
        // 初始化
        for (int[] tmp : dp) {
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        for (int i = 1; i <= len; i++) {
            dp[i][1] = preSum[i];
        }
        for (int i = 1; i <= len; i++) { // 先遍历元素
            for (int k = 1; k <= Math.min(i, group); k++) { // 再遍历组
                for (int l = 0; l <= i - 1; l++) {
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[l][k-1], preSum[i] - preSum[l]));
                }
            }
        }
        return dp[len][group];

    }

    public static int splitArray(int[] nums, int group) {
        // 思路
        // 二分法
        // 理解： 最大值的最小值  > 所有元素里面大的 maxNum。  < 小于所有元素的总和 totalSum
        // 使用二分法，先从 (maxNum + totalSum) / 2 开始寻找 （每大于等于中间值 分割数量+1）
        // 如果分割的数量 > m 说明 不符合要求，分割的数量太多了
        //  提高 mid的值，这样减少分割量
        //
        // 如果设置「数组各自和的最大值」很大，那么必然导致分割数很小；
        // 如果设置「数组各自和的最大值」很小，那么必然导致分割数很大。
        //
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            sum += num;
        }
        int left = maxNum;
        int rigth = sum;
        while (left < rigth) {
            int mid = (left + rigth) / 2;
            if (check(nums, mid) > group) {
                left = mid + 1;
            } else {
                rigth = mid;
            }
        }
        return left;
    }

    private static int check(int[] arrays, int targetNum) {
        int split = 1;
        int curSum = 0;
        for (int num : arrays) {
            // 尝试加上当前遍历的这个数，如果加上去超过了「子数组各自的和的最大值」，就不加这个数，另起炉灶
            if (curSum + num > targetNum) {
                split++;
                curSum = 0;
            }
            curSum += num;
        }
        return split;
    }

    private static int[] genPreSum(int[] array, int len) {
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i-1] + array[i - 1];
        }
        return preSum;
    }
}
