package com.wkk.top.twopointer;

/**
 * @author kongwiki@163.com
 * @since 2020/8/8上午11:25
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int idx = 0;
        int a, b;
        int[] res = new int[m+n];
        while(i < m || j<n){
            a = i>=m ? Integer.MAX_VALUE : nums1[i];
            b = j>=n ? Integer.MAX_VALUE : nums2[j];
            res[idx++] = a < b ? nums1[i++] : nums2[j++];

        }
        idx = 0;
        while (idx < res.length){
            nums1[idx] = res[idx];
            idx++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
