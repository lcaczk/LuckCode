package com.wkk.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author kongwiki@163.com
 * @since 2021/1/31
 */
public class LC_001 {
    /**
     * 暴力循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumII(int[] nums, int target) {
        // TODO 暴力循环
        return new int[2];
    }

    /**
     * map用于记录已存在
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return new int[2];
        }
        int n = nums.length;
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                results[1] = i;
                results[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return results;
    }
}
