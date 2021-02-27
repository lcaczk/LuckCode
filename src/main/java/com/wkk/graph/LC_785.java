package com.wkk.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785 判断二分图
 * @author weikunkun
 * @since 2021/2/27
 */
public class LC_785 {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    /**
     * 判断二分图
     * 作色问题
     * 广度优先搜索
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = cNei;
                        } else if (color[neighbor] != cNei) {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}
