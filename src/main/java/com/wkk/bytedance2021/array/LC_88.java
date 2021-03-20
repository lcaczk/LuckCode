package com.wkk.bytedance2021.array;

/**
 * @author weikunkun
 * @since 2021/3/18
 */
public class LC_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int k = 0;
        for (int num : nums1) {
            nums[k++] = num;
        }
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < m && j < n) {
            int cur = 0;
            if (nums[i] < nums2[j]) {
                cur = nums[i++];
            } else {
                cur = nums2[j++];
            }
            nums1[idx++] = cur;
        }
        while (j < n) {
            nums1[idx++] = nums2[j++];
        }
        while (i < m) {
            nums1[idx++] = nums[i++];
        }
    }
}
