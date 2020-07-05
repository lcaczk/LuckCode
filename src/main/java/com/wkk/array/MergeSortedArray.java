package com.wkk.array;

/**
 * @Time: 2020/7/4下午10:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            nums[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
        }
        while (i < m) {
            nums[k++] = nums1[i++];
        }
        while (j < n) {
            nums[k++] = nums2[j++];
        }
        for (int y = 0; y < nums.length; y++) {
            nums1[y] = nums[y];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }

    }
}
