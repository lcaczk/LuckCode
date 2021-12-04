package com.wkk.interview.bytedance2021.binarysearch;

/**
 * 162. 寻找峰值
 * 思路 二分查找
 * @author weikunkun
 * @since 2021/4/7
 */
public class LC_162 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
