package com.wkk.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/6/26
 */
public class LC_323 {
    public int countComponents(int n, int[][] edges) {
        // 构建图
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        // 遍历顶点
        int count = 0;
        boolean[] visited=  new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (Integer next : adj.get(node)) {
                        // 一组
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return  count;
    }
}
