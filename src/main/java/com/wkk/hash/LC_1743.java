package com.wkk.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/7/25
 */
public class LC_1743 {
    static int n = (int) 2e5;
    static int base = (int) 1e5;
    public static int[] restoreArray(int[][] adjacentPairs) {
        // 类似拓扑排序
        // 如何存储 邻接表 邻接矩阵
        // 使用 map 存储， 视为邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adj : adjacentPairs) {
            int cur = adj[1];
            int pre = adj[0];
            map.computeIfAbsent(cur, list -> new ArrayList<>()).add(pre);
            map.computeIfAbsent(pre, list -> new ArrayList<>()).add(cur);
        }
        int starter = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                starter = entry.getKey();
                break;
            }
        }
        boolean[] visited = new boolean[n + 1];
        List<Integer> ans = new ArrayList<>();
        List<Integer> list = map.get(starter);
        Queue<Integer> queue = new LinkedList<>();
        ans.add(starter);
        visited(visited, starter);
        queue.addAll(list);
        list.stream().forEach(i -> {
            visited[i + base] = true;
        });
        while (!queue.isEmpty()) {
            int p = queue.poll();
            ans.add(p);
            visited(visited, p);
            for (int num : map.get(p)) {
                if (!visited[num + base]) {
                    queue.offer(num);
                    visited(visited, num);
                }
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private static void visited(boolean[] visited, int idx) {
        visited[idx + base] = true;
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 1}, {3, 4}, {3, 2}};
        restoreArray(nums);
    }
}
