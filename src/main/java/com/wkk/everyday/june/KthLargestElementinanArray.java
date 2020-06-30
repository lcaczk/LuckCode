package com.wkk.everyday.june;

import java.util.Arrays;

/**
 * @Time: 2020/6/29下午4:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = nums.length-1; i>=0 ; i--){
            if(--k == 0){
                res = nums[i];
                break;
            }
        }
        return res;
    }

    public int findKthLargestII(int[] nums, int k ){
        // 快排
        int low = 0;
        int height = nums.length-1;
        int position = position(nums, low, height);
        int s = nums.length-k-1;
        while (position != s){
            if(position < s){
                low = position+1;
                position = position(nums, low, height);
            }else {
                height = position;
                position = position(nums, low, height);
            }
        }
        return position;

    }
    private int position(int[] nums, int low, int height){
        int position = nums[low];
        while (low < height){
            while (low < height && nums[height] >= position ){
                height--;
            }
            nums[height] = nums[low];
            while (low < height && nums[low] <= position){
                low++;
            }
            nums[low] = nums[height];
        }
        nums[low] = position;
        return low;
    }

}
