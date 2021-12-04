package com.wkk.interview.bytedance2021.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 两数之和
 *
 * @author weikunkun
 * @since 2021/3/14
 */
public class LC_1 {
    public int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return new int[2];
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int rest = target - nums[i];
            if (map.containsKey(rest)) {
                result[0] = map.get(rest);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
