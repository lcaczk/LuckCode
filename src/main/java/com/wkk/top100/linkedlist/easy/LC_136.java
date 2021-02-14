package com.wkk.top100.linkedlist.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 136. 只出现一次的数字
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_136 {

    /**
     * 异或
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int pre = 0;
        for(int num : nums) {
            pre = pre ^ num;
        }
        return pre;
    }

    public int singleNumberII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> collect = map.keySet().stream().filter(key -> map.get(key) == 1).collect(Collectors.toList());
        return collect.get(0);
    }
}
