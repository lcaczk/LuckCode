package com.wkk.simulation.lc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/12/5
 */
public class LC_5932 {
    public int[][] validArrangement(int[][] pairs) {
        // 图的遍历
        int rows = pairs.length;
        int cols = pairs[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pair : pairs) {
            int first = pair[0];
            int second = pair[1];
            map.computeIfAbsent(first,list -> new ArrayList<>()).add(second);
        }
        int[][] res = new int[rows][cols];

        for (Integer key : map.keySet()) {
            boolean flag = false;
            int idx = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            res = new int[rows][cols];
            queue.offer(key);
            while (!queue.isEmpty()) {
                int cur = queue.pop();
                if (idx == map.size()) {
                    flag = true;
                }
                res[idx][0] = cur;
                res[idx][1] = map.get(cur).get(0);
                List<Integer> next = map.get(cur);
                for (int nextVal : next) {
                    if (!map.containsKey(nextVal)) {
                        break;
                    }
                    queue.offer(nextVal);
                }
                idx++;
            }
            if (flag) {
                break;
            }
        }
        return res;
    }
}
