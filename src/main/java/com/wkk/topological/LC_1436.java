package com.wkk.topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/10/1
 */
public class LC_1436 {
    public static String destCity(List<List<String>> paths) {
        // 拓扑排序
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (List<String> path : paths) {
            String pre = path.get(0);
            String cur = path.get(1);
            adj.computeIfAbsent(pre, list -> new ArrayList<>()).add(cur);
            indegree.put(cur, indegree.getOrDefault(cur, 0) + 1);
            indegree.put(pre, indegree.getOrDefault(pre, 0));
        }

        Queue<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        String res = "";
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> list = adj.getOrDefault(cur, new ArrayList<>());
                if (list.isEmpty()) {
                    res = cur;
                    break;
                }
                for (String str : list) {
                    if (indegree.get(str) - 1 == 0) {
                        queue.offer(str);
                        indegree.put(str, indegree.get(str) - 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("London", "New York"));
        list.add(Arrays.asList("New York", "Lima"));
        list.add(Arrays.asList("Lima", "Sao Paulo"));
        System.out.println(destCity(list));
    }
}
