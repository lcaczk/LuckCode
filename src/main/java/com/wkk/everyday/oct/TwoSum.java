package com.wkk.everyday.oct;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目: 两数之和
 * 链接: https://leetcode-cn.com/problems/two-sum/submissions
 * 思路: 各种解法
 * @author kongwiki@163.com
 * @since 2020/10/3
 */
public class TwoSum {
    // map 大法
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }

}
