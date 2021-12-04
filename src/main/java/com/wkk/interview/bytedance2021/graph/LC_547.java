package com.wkk.interview.bytedance2021.graph;

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
     *
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
     *
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

    public int findCircleNumIII(int[][] isConnected) {
        int n = isConnected.length;
        // 初始化并查集
        UnionFind uf = new UnionFind(n);
        // 遍历每个顶点，将当前顶点与其邻接点进行合并
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        // 返回最终合并后的集合的数量
        return uf.size;
    }

    // 并查集
    class UnionFind {
        int[] roots;
        int size; // 集合数量

        public UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
            size = n;
        }

        public int find(int i) {
            if (i == roots[i]) {
                return i;
            }
            return roots[i] = find(roots[i]);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                roots[pRoot] = qRoot;
                size--;
            }
        }

    }
}
