package com.wkk.interview.bytedance2021.binarysearch;

/**
 * 33 搜索旋转排序数组
 * @author weikunkun
 * @since 2021/3/16
 */
public class LC_33 {
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
        int[] array = {1, 3};
        LC_33 lc_33 = new LC_33();
        int target = 3;
        lc_33.search(array, target);
    }
}
