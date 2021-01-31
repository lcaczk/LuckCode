package com.wkk.top100.array.hard;

import java.util.Arrays;

/**
 * @author kongwiki@163.com
 * @since 2021/1/31
 */
public class LC_004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Arrays.sort();
        int m = nums1.length;
        int n = nums2.length;
        int totalLen = m + n;
        int[] newnums = new int[totalLen];
        int j = 0;
        if (null != nums1) {
            for(int i : nums1) {
                newnums[j++] = i;
            }
        }
        if (null != nums2) {
            for(int i : nums2) {
                newnums[j++] = i;
            }
        }
        Arrays.sort(newnums);
        if(totalLen%2 == 0) {
            // 长度为偶数
            int first = newnums[totalLen/2];
            int second = newnums[totalLen/2 - 1];
            return (first + second)/2.0;
        } else {
            return newnums[totalLen/2];
        }

    }

    public static void main(String[] args) {
        int[] first = {1,2};
        int[] second = {3,4};
        findMedianSortedArrays(first, second);
    }
}
