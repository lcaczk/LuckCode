package com.wkk.twopointer.slidewindow;

/**
 * @author weikunkun
 * @since 2021/5/27
 */
public class LC_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 滑动窗口
        int N = nums.length;
        int left = 0;
        int sum = 1;
        int count = 0;
        for (int right = 0; right < N; right++) {
            sum *= nums[right];
            while (left <= right && sum >= k) {
                sum /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
