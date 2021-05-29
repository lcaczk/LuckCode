package com.wkk.twopointer;

/**
 * @author weikunkun
 * @since 2021/5/27
 */
public class LC_80 {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    private int process(int[] nums, int k) {
        int idx = 0;
        for (int x : nums) {
            if (idx < k || nums[idx - k] != x) {
                nums[idx++] = x;
            }
        }
        return idx;
    }
}
