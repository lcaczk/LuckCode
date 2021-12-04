package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/7/6
 */
public class LC_4 {
    public static double findMedianSortedArraysI(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 0) {
            return (getNum(nums1, nums2, total / 2, m, n) + getNum(nums1, nums2, total / 2 - 1, m, n)) / (double)2;
        } else {
            return (double) getNum(nums1, nums2, total / 2, m, n);
        }
    }

    private static int getNum(int[] nums1, int[] nums2, int k, int m, int n) {
        int i = 0;
        int j = 0;
        int idx = 0;
        int[] arr = new int[m + n];
        while (i < m && j < n && idx <= k) {
            if (nums1[i] < nums2[j]) {
                arr[idx++] = nums1[i++];
            } else {
                arr[idx++] = nums2[j++];
            }
        }
        while (i < m && idx <= k) {
            arr[idx++] = nums1[i++];
        }
        while (j < n && idx <= k) {
            arr[idx++] = nums2[j++];
        }
        return arr[idx];
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        // 基础判断条件
        //选择长度较小的那个数组进行查找
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        if (nums1.length == 0) {
            if (nums2.length % 2 != 0) return nums2[length / 2];
            else return (nums2[length / 2 - 1] + nums2[length / 2]) / 2.0;
        }
        ////初始化二分查找的边界
        int L_edge = 0, R_edge = nums1.length;
        int cur1 = 0, cur2 = 0;
        double result = 0;
        while (L_edge <= R_edge) {
            cur1 = L_edge + (R_edge - L_edge) / 2;
            cur2 = (length + 1) / 2 - cur1;
            //计算出L1，R1，L2，R2
            double L1 = cur1 == 0 ? Integer.MIN_VALUE : nums1[cur1 - 1];
            double R1 = cur1 == nums1.length ? Integer.MAX_VALUE : nums1[cur1];
            double L2 = cur2 == 0 ? Integer.MIN_VALUE : nums2[cur2 - 1];
            double R2 = cur2 == nums2.length ? Integer.MAX_VALUE : nums2[cur2];
            //二分查找，重新划定边界
            if (L1 > R2) R_edge = cur1 - 1;
            else if (L2 > R1) L_edge = cur1 + 1;
            else {
                //注意长度为奇数偶数的问题，奇数取中间的那个值，偶数则取两边的和的一半
                if (length % 2 != 0) result = Math.max(L1, L2);
                else result = (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] first = {2, 3, 8, 10, 12};
        int[] second = {1, 4, 5, 6, 7, 9, 13, 14};
        findMedianSortedArraysI(first, second);
    }
}
