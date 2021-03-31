package com.wkk.bytedance2021.sort;

/**
 * 912 排序数组
 * @author weikunkun
 * @since 2021/3/31
 */
public class LC_912 {
    /**
     * 堆排
     */

    /**
     * 归并排序
     */

    /**
     * 快排
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left ,int right) {
        if (left > right) {
            return;
        }
        int partition = postition(nums, left, right);
        quickSort(nums, left, partition-1);
        quickSort(nums, partition+1, right);
    }
    private int postition(int[] nums, int left, int right) {
        int target = nums[left];
        while (left < right) {
            while(left < right && nums[right] >= target ) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= target) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = target;
        return left;
    }
}
