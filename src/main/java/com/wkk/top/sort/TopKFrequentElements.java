package com.wkk.top.sort;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author kongwiki@163.com
 * @since 2020/8/10上午9:39
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 维护前k高的优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> (map.get(x) - map.get(y)));

        for (int num : map.keySet()) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int idx = k - 1;
        while (idx >= 0) {
            res[idx] = queue.poll();
            idx--;
        }
        return res;

    }
}
