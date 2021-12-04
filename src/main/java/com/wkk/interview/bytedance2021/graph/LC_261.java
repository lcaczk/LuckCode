package com.wkk.interview.bytedance2021.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 261 以图判树
 *
 * @author weikunkun
 * @since 2021/3/31
 */
public class LC_261 {
    /**
     * 广度优先遍历
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        // 邻接矩阵存储
        // 然后使用广度遍历
        // 使用visited标记访问过的节点
        boolean[] visited = new boolean[n];
        int[][] graph = new int[n][n];
        // 构造图
        for (int[] edge : edges) {
            int pre = edge[0];
            int cur = edge[1];
            graph[pre][cur] = 1;
            graph[cur][pre] = 1;
        }
        // 开始搜索
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            // 遍历其相邻的节点
            for (int i = 0; i < n; i++) {
                if (graph[node][i] == 1) {
                    // 相邻的节点已经被访问过
                    // 说明存在环，返回false
                    if (visited[i]) {
                        return false;
                    }
                    visited[i] = true;
                    graph[node][i] = 0;
                    graph[i][node] = 0;
                    queue.offer(i);
                }
            }
        }

        // 判断是否为连通图
        // 不是，也说明，不存在
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深度优先遍历
     */


    /**
     * 拓扑排序
     */
    public boolean validTreeIII(int n, int[][] edges) {
        // 思路，不构成环
        // 方法 拓扑排序
        // 统计每个节点的度 （入度+出度）
        int[] indegree = new int[n];
        int nums = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int pre = edge[0];
            int cur = edge[1];
            adj.get(pre).add(cur);
            adj.get(cur).add(pre);
            indegree[cur]++;
            indegree[pre]++;
        }
        // 先选择度为1的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            nums++;
            for (int next : adj.get(node)) {
                if (--indegree[next] == 1) {
                    if (visited[next]) {
                        return false;
                    }
                    queue.offer(next);
                }
            }
        }
        return nums == n;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] matrix1 = {{0, 1}, {2, 3}};
        int[][] matrix2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        LC_261 lc_261 = new LC_261();
        lc_261.validTreeIII(4, matrix1);
    }

}
