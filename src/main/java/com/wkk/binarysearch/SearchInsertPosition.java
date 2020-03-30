package com.wkk.binarysearch;

/**
 * @Time: 20-3-30下午3:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length-1]){
            return nums.length;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(nums[mid] < target){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        int i = searchInsert(a, 7);
        System.out.println(i);
    }
}
