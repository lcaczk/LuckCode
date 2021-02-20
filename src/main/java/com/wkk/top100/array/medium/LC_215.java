package com.wkk.top100.array.medium;

import java.util.Arrays;

/**
 * 215 数组中的第k大的元素
 *
 * @author weikunkun
 * @since 2021/2/19
 */
public class LC_215 {
    /**
     * java内置排序库排序之后返回第k大的数字
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 排序之后返回第k大的元素
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 使用快排
     * 快排的性质中，每排序一次，都能确定一个元素的位置
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        k = nums.length - k;
        int position = priority(nums, 0, nums.length - 1);
        while (position != k) {
            if (position < k) {
                position = priority(nums, position+1, nums.length-1);
            } else {
                position = priority(nums, 0, position-1);
            }
        }
        return nums[position];

    }

    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int left, int right) {
        while (left < right) {
            int index = priority(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    private int priority(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}

