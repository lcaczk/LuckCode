package com.wkk.dp.interval;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/5/12
 */
public class LC_813 {
    public static double largestSumOfAverages(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0D;
        }
        int len = nums.length;
        // dp[i][j]: 前i个元素，划分为j组，获得的最大平均总值
        double[][] dp = new double[len+1][k+1];
        // 优化 获取前缀和
        //存储前缀和
        double[] prefixSum = getPrefixSum(nums);
        // int[] prefixSum = new int[len + 1];
        // for(int i = 1; i <= len; i++){
        //     prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        // }

        for (int i = 1; i <= len; i++) { // 元素
            for (int j = 1; j <= Math.min(i, k); j++) { // 组
                if(j == 1){ //针对只有1个分组的情况
                    dp[i][j] = (double)prefixSum[i] / i;
                    continue;
                }
                for (int l = 0; l <= i - 1; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[l][j-1] + (double)(prefixSum[i] - prefixSum[l]) / (i - l));
                }
            }
        }
        return dp[len][k];
    }

    private static double[] getPrefixSum(int[] nums) {
        int len = nums.length;
        double[] prefixSum = new double[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,2,5,6};
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int[] ints = collect.stream().mapToInt(Integer::intValue).toArray();
        int group = 3;
        System.out.println(largestSumOfAverages(nums, group));
    }
}
