package com.wkk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time: 20-4-2上午10:48
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = hashMap.get(target-nums[i]);
                break;
            }
            hashMap.put(nums[i], i);
        }
        return res;
    }
}
