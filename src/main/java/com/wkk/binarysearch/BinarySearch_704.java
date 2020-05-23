package com.wkk.binarysearch;

/**
 * @Time: 2020/5/23下午6:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            // 防止整型溢出
            // int mid = i + (j-i)/2;
            int mid = (i+j)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                i = mid+1;
            }else if(nums[mid] > target){
                j = mid-1;
            }
        }
        return -1;
    }
}
