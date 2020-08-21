package com.wkk.easy;

import java.util.HashMap;

/**
 * @Time: 20-3-24下午1:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        if(nums.length <= 0){
//            return false;
//        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < i+k && j< nums.length; j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicateII(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) < k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
