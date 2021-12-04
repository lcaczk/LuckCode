package com.wkk.prefix;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class LC_724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = preSum(nums, n);
        for (int i = 1; i <= n; i++) {
            if (preSum[i - 1] == preSum[n] - preSum[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    private int[] preSum(int[] nums, int n) {
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        return preSum;
    }
}
