package com.wkk.sort.merge;

/**
 *
 * @author weikunkun
 * @since 2021/6/9
 */
public class LC_315 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + right >> 1;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        int[] tmp = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                count += mid - i + 1;
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }

        // 兜底
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        for (i = 0, j = left; j <= right; j++, i++) {
            nums[j] = tmp[i];
        }
        return count;
    }
}
