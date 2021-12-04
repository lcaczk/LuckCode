package com.wkk.simulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/6/4
 */
public class 多人分小区 {
    private static int N;

    public static double largestAvg(int[] nums, int k) {
        N = nums.length;
        int[] preSum = genPreSum(nums);
        int total = preSum[N];
        // sum[i, j] = preSum[j + 1] - preSum[i]
        // rst = total - sum[i, j]
        double max = Double.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            int j = i + 1;
            while (j < N) {
                int curSum = preSum[j + 1] - preSum[i];
                int curNum = j - i + 1;
                int rstSum = total - curSum;
                int rstNum = N - curNum;
                double curAvg = (double) (curSum / curNum) + (double) (rstSum / rstNum);
                max = Math.max(curAvg, max);
                j++;
            }
        }
        return max;
    }

    /**
     * 不连续，直接暴力
     * @param nums
     * @return
     */
    private static int ans = Integer.MIN_VALUE;
    private static int total;
    public static int largestAvg(int[] nums) {
        total = Arrays.stream(nums).sum();
        dfs(nums, 0, new ArrayDeque<>());
        return ans;
    }

    private static void dfs(int[] nums, int idx, Deque<Integer> list) {
        if (idx > nums.length) {
            return;
        }
        if (!list.isEmpty()) {
            int curSum = list.stream().mapToInt(i->i).sum();
            int retSum = total - curSum;
            if (list.size() != nums.length) {
                ans = Math.max(ans, curSum / list.size() + retSum / (nums.length - list.size()));
            }
        }
        for (int i = idx; i < nums.length; i++) {
            list.addLast(nums[i]);
            dfs(nums, i + 1,list);
            list.removeLast();
        }
    }


    private static int[] genPreSum(int[] nums) {
        int[] preSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        return preSum;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 1};
        System.out.println(largestAvg(array, 2));
    }
}
