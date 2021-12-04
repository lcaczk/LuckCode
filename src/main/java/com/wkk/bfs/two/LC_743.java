package com.wkk.bfs.two;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/8/2
 */
public class LC_743 {
    public static int networkDelayTime(int[][] times, int n, int k) {
        // map key : node  value : [node, time];
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] time : times) {
            int cur = time[0];
            int[] next = new int[2];
            next[0] = time[1]; // next node
            next[1] = time[2]; // time
            map.computeIfAbsent(cur, list -> new ArrayList<>()).add(next);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            List<int[]> adj = map.getOrDefault(u, new ArrayList<>());
            for (int[] nextAdj : adj) {
                if (time[nextAdj[0]] > time[u] + nextAdj[1]) {
                    time[nextAdj[0]] = time[u] + nextAdj[1];
                    queue.offer(nextAdj[0]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (time[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, time[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(matrix, 4, 2));
    }
}
