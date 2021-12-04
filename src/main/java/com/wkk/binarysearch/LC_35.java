package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/7/12
 */
public class LC_35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        if (nums[r] < target) {
            return r + 1;
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
