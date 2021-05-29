package com.wkk.twopointer;

/**
 * @author weikunkun
 * @since 2021/5/27
 */
public class LC_26 {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int x : nums) {
            if (idx < 1 || nums[idx - 1] != x) {
                nums[idx++] = x;
            }
        }
        return idx;
    }
}
