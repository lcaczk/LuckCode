package com.wkk.bytedance2021.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 785 判断二分图
 * 通过广度或深度遍历 进行染色
 *
 * @author weikunkun
 * @since 2021/3/31
 */
public class LC_785 {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;  //类似于标记已经访问过的元素

    /**
     * 广度遍历 并 进行染色
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        // TODO 参数校验
        int numbers = graph.length;
        color = new int[numbers];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        color[0] = RED;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            int nextColor = color[cur] == RED ? GREEN : RED;
            for (int node : graph[cur]) {
                if (color[node] == UNCOLORED) {
                    color[node] = nextColor;
                    queue.offer(node);
                } else if (color[node] != nextColor) {
                    // 已经染过色 并且和相邻的节点同色
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteI(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int nextColor = color[node] == RED ? GREEN : RED;
                    for (int number : graph[node]) {
                        if (color[number] == UNCOLORED) {
                            queue.offer(number);
                            color[number] = nextColor;
                        } else if (color[number] != nextColor) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
