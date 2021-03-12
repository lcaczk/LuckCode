package com.wkk.bytedance2021.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 215 数组中的第k个最大元素
 * 思路：
 * 1. 排序后进行查找
 * 2. 根据快排思想查找
 *
 * @author weikunkun
 * @since 2021/3/13
 */
public class LC_215 {
    public int findKthLargest(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        k = nums.length - k;
        int position = priority(nums, 0, nums.length - 1);
        while (position != k) {
            if (position < k) {
                position = priority(nums, position + 1, nums.length - 1);
            } else {
                position = priority(nums, 0, position - 1);
            }
        }
        return nums[position];

    }

    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
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
