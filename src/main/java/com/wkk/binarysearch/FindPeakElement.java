package com.wkk.binarysearch;

import java.util.HashMap;

/**
 * @Time: 20-3-30下午5:41
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int hight = nums.length - 1;
        int mid = low;
        while (low < hight) {
            mid = (low + hight) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }else {
                hight = mid;
            }
        }
        return low;
    }
}
