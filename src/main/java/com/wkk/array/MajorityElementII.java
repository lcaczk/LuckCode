package com.wkk.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Time: 20-3-30下午2:44
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], hashMap.get(nums[i])+1);
            }else {
                hashMap.put(nums[i], 1);
            }
            if(hashMap.get(nums[i]) > nums.length/3 && list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        return list;
    }
}
