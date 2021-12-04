package com.wkk.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/8/5
 */
public class LC_802 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        // 思路
        // 有环 不添加
        // 无环 添加

        // 实现方式
        // dfs、 bfs、拓扑
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = graph.length;
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int num : graph[i]) {
                map.computeIfAbsent(num, list -> new ArrayList<>()).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int adj : map.getOrDefault(cur, new ArrayList<>())) {
                if (--indegree[adj] == 0) {
                    queue.offer(adj);
                    res.add(adj);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }
}
