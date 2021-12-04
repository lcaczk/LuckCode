package com.wkk.binarysearch;

/**
 * 29. 两数相除
 * @author weikunkun
 * @since 2021/7/12
 */
public class LC_29 {
    private int[] nums;
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        this.nums = nums;
        // 先找到旋转点儿
        int lowIdx = findLower(0, nums.length-1);
        // 刚好为该值
        if (target == nums[lowIdx]) {
            return lowIdx;
        }
        // 最大元素也小于target
        if (lowIdx > 1 && target > nums[lowIdx-1]) {
            return -1;
        }
        // 然后从两个有序数组中二分查找
        if (target <= nums[nums.length-1]) {
            return findTarget(lowIdx, nums.length-1, target);
        } else {
            return findTarget(0, lowIdx-1, target);
        }
    }

    private int findLower(int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findTarget(int left, int right, int target) {
        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {

    }
}
