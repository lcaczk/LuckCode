package com.wkk.math;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/11/20
 */
public class LC_594 {
    public int findLHS(int[] nums) {
        // 思路
        // 对应规则中的子数组内部元素要么相等，要么元素差为1
        // 同时是子序列，并且只比较大小，所以如何获取子数组，顺序并不重要了
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cur = entry.getKey();
            if (map.containsKey(cur + 1)) {
                ans = Math.max(ans, entry.getValue() + map.get(cur + 1));
            }
        }
        Map<Integer, List<Integer>> freq = new HashMap<>();
        return ans;
    }
}
