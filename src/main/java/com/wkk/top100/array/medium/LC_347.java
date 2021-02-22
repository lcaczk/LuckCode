package com.wkk.top100.array.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前k个高频元素
 * 思路： 堆
 *
 * @author weikunkun
 * @since 2021/2/21
 */
public class LC_347 {
    /**
     * 使用堆+hashmap组合
     * 1. map用于统计出现的次数
     * 2. 堆用于维护topK问题
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (null == nums || nums.length == 0 || nums.length < k) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 通过大根堆进行维护
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        for (int num : map.keySet()) {
            queue.offer(num);
        }
        int i = 0;
        while (i  < k && !queue.isEmpty()) {
            result[i++] = queue.poll();
        }
        return result;
    }
}
