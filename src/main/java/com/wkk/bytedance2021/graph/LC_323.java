package com.wkk.bytedance2021.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/5/2
 */
public class LC_323 {
    private int count = 0;
    public int countComponents(int n, int[][] edges) {
        // dfs
        boolean[] visited = new boolean[n];
        // 构造邻接矩阵
        int[][] graph = new int[n][n];
        for (int[] array : edges) {
            int pre = array[0];
            int cur = array[1];
            graph[pre][cur] = 1;
            graph[cur][pre] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, graph);
            }
        }
        return count;
    }

    private void dfs(int i, boolean[] visited, int[][] graph) {
        visited[i] = true;
        for (int j = 0; j < graph.length; i++) {
            if (graph[i][j] == 1 && !visited[i]) {
                dfs(j, visited, graph);
            }
        }
    }

    public int countComponentsII(int n, int[][] edges) {
        int count = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, adjList);
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int index, List<List<Integer>> adjList) {
        visited[index] = true;
        for (int i : adjList.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, adjList);
            }
        }
    }

}
