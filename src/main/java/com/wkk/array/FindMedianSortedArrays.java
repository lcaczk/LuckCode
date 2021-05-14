package com.wkk.array;

/**
 * @author weikunkun
 * @since 2021/5/14
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并之后找中间结果
        // 归并排序
        int[] res = mergeSort(nums1, nums2);
        int len = res.length;
        if (len % 2 == 1) {
            // 奇数
            return res[len / 2];
        } else {
            // 偶数
            return (res[len / 2 ] + res[len / 2 + 1]) / 2;
        }
    }
    private static int[] mergeSort(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1 + len2];
        int i = 0, k = 0, idx = 0;
        while (i < len1 && k < len2) {
            if (nums1[i] <= nums2[k]) {
                res[idx++] = nums1[i++];
            } else {
                res[idx++] = nums2[k++];
            }
        }
        // 收尾
        while (i < len1) {
            res[idx++] = nums1[i++];
        }
        while (k < len2) {
            res[idx++] = nums2[k++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {};
        int[] array1 = {2,4};
        findMedianSortedArrays(array, array1);
    }
}
