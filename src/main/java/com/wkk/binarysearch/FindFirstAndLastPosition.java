package com.wkk.binarysearch;

/**
 * @Time: 2020/5/23下午9:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int first = findFirstPosition(nums, target);
        if(first == 1){
            return new int[]{-1, -1};
        }
        int secondPosition = findSecondPosition(nums, target);
        return new int[]{first, secondPosition};
    }

    public int findFirstPosition(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            // 小于一定没有解
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (nums[i] == target) {
            return i;
        } else {
            return -1;
        }
    }

    public int findSecondPosition(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            int mid = (i + j + 1)/2;
            if(nums[mid] > target){
                j = mid-1;
            }else {
                i = mid;
            }
        }
        if (nums[i] == target){
            return i;
        }else {
            return -1;
        }
    }
}
