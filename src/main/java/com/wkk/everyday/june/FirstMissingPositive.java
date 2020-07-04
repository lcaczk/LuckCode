package com.wkk.everyday.june;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Time: 2020/6/27下午8:02
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int max = nums[nums.length-1];
        for(int i = 1; i< max; i++){
            if(!map.containsKey(i)){
                res = i;
                return res;
            }
        }
        return res;
    }

    public static int firstMissingPositiveII(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i]-1] != nums[i] ){
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3,4,-1,1};
        int i = firstMissingPositiveII(a);
        System.out.println(i);
    }
}
