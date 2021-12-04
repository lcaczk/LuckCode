package com.wkk.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/7/1
 */
public class LCP_07 {
    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] rel : relation) {
            adj.get(rel[0]).add(rel[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty() && step < k) {
            int size = queue.size();
            step++;
            while (size-- > 0) {
                int idx = queue.poll();
                for(int next : adj.get(idx)) {
                    queue.offer(next);
                }
            }
        }
        int count = 0;
        if (step == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == n - 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
