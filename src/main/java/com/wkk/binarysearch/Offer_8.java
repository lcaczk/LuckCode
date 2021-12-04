package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/8/10
 */
public class Offer_8 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] preSum = genPreSum(nums, n);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int next = preSum[i] + target;
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + right >> 1;
                if (preSum[mid] < next) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            min = Math.min(min, left - i);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private static int[] genPreSum(int[] nums, int n) {
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        return preSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        minSubArrayLen(target, arr);
    }
}
