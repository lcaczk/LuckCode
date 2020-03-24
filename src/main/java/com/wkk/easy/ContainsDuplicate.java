package com.wkk.easy;

import java.util.HashSet;

/**
 * @Time: 20-3-24下午2:42
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }
}
