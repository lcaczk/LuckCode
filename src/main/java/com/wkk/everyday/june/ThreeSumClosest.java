package com.wkk.everyday.june;

import java.util.Arrays;

/**
 * @Time: 2020/6/24下午8:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Math.abs(nums[0] + nums[nums.length-1] + nums[1] - target);
        int res = diff;
        for(int i = 0; i<nums.length-2; i++){
            int low = i+1;
            int height = nums.length-1;
            while(low < height){
                int temp = nums[i] + nums[low] + nums[height];
                if(temp < target){
                    low++;
                }else {
                    height--;
                }
                if(Math.abs(temp-target)< diff){
                    diff = Math.abs(temp-target);
                    res = temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest closest = new ThreeSumClosest();
        int[] a = {0,1,2};
        int i = closest.threeSumClosest(a, 3);
        System.out.println(i);

    }
}
