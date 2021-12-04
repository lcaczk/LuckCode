package com.wkk.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/12/2
 */
public class LC_500 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> (y - x));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            queue.offer(score[i]);
            map.put(score[i], i);
        }

        int count = 0;
        String[] res = new String[n];
        while (!queue.isEmpty()) {
            int val = queue.poll();
            int idx = map.get(val);
            if (count == 0) {
                res[idx] = "Gold Medal";
            } else if (count == 1) {
                res[idx] = "Silver Medal";
            } else if (count == 2) {
                res[idx] = "Bronze Medal";
            } else {
                res[idx] = count + 1 + "";
            }
            count++;
        }
        return res;
    }
}
