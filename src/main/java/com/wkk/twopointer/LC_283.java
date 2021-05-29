package com.wkk.twopointer;

/**
 * 移动零
 * @author weikunkun
 * @since 2021/5/27
 */
public class LC_283 {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int idx = 0;
        for (int x : nums) {
            if (x != 0) {
                nums[idx++] = x;
            }
        }
        for (int i = idx; i < N; i++) {
            nums[i] = 0;
        }
    }
}
