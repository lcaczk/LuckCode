package com.wkk.everyday.july;

/**
 * @Time: 2020/7/17上午10:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if(nums[high] < target){
            return nums.length;
        }
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid]< target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        int i = searchInsert(a, 7);
        System.out.println(i);
    }

}
