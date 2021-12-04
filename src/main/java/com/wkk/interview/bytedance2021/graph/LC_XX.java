package com.wkk.interview.bytedance2021.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/3/31
 */
public class LC_XX {
    public boolean validTree(int n, int[][] edges) {
        // 思路，不构成环
        // 方法 拓扑排序
        // 统计每个节点的度 （入度+出度）
        int[] indegree = new int[n];
        int nums = 0;
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
            nums++;
            for (int next : adj.get(node)) {
                if (--indegree[next] == 1) {
                    queue.offer(next);
                }
            }
        }
        return nums == n;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] matrix1 = {{0, 1}, {2, 3}};
        LC_XX lc_xx = new LC_XX();
        lc_xx.validTree(4, matrix1);
    }
}
