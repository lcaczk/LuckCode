package com.wkk.greedy;

/**
 * @author weikunkun
 * @since 2021/7/19
 */
public class LC_55 {
    public static boolean canJump(int[] nums) {
        // 贪心
        int right = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= right) {
                int innerRight = nums[i] + i;
                right = Math.max(right, innerRight);
                if (right >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
