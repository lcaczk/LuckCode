package com.wkk.top100.array.medium;

import java.util.Arrays;

/**
 * 75 颜色的分类
 * 思路：排序
 * @author weikunkun
 * @since 2021/2/21
 */
public class LC_75 {
    // 排序
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
        return;
    }

    // 快排
    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int left, int right) {
        // 内部会存在 left right 不更新的情况，所以使用if 方式陷入死循环
        if (left < right) {
            int position = position(nums, left, right);
            quickSort(nums, left, position-1);
            quickSort(nums, position+1, right);
        }
    }

    private int position(int[] nums, int left, int right) {
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

    public static void main(String[] args) {
        LC_75 lc_75 = new LC_75();
        int[] nums = {1,4,3,2};
        lc_75.quickSort(nums);
    }
}
