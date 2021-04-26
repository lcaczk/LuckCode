package com.wkk.bytedance2021.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 547 省份数量
 *
 * @author weikunkun
 * @since 2021/4/23
 */
public class LC_547 {
    /**
     * 图的简单实用
     * dfs / bfs
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int rows = isConnected.length;
        boolean[] visited = new boolean[rows];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private void dfs(int cur, int[][] graph, boolean[] visited) {
        visited[cur] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[cur][i] == 1 && !visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }

    /**
     * 广度遍历
     * @param isConnected
     * @return
     */
    public int findCircleNumII(int[][] isConnected) {
        // 广度遍历
        int rows = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        boolean[] visited = new boolean[rows];
        for (int i = 0; i < rows; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count++;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int j = 0; j < isConnected[cur].length; j++) {
                        if (!visited[j] && isConnected[cur][j] == 1) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }

                }
            }
        }
        return count;
    }
}
