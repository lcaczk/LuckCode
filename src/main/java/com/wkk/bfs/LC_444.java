package com.wkk.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/9/15
 */
public class LC_444 {
    private int totoalNode = (int) 1e4;

    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // 思路：
        // 拓扑排序 (严格)
        // 使用邻接表来做存储 底层通过 map实现
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        int n = org.length;
        for (List<Integer> tmp : seqs) {
            int size = tmp.size();
            for (int i = 0; i < size - 1; i++) {
                int pre = tmp.get(i);
                int cur = tmp.get(i + 1);
                adj.computeIfAbsent(pre, list -> new HashSet<>()).add(cur);
                indegree.put(cur, indegree.getOrDefault(cur, 0) + 1);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int idx = 0;
        for (int key : indegree.keySet()) {
            if (org[idx] == key && indegree.get(key) != 0) {
                return false;
            } else if (org[idx] == key && indegree.get(key) == 0) {
                queue.offer(idx);
            } else if (indegree.get(key) == 0) {
                return false;
            }
        }
        idx++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int num : adj.get(cur)) {
                    if (num == org[idx]) {
                        queue.offer(num);
                        indegree.put(num, indegree.get(num) - 1);
                    }
                }
                idx++;
            }
        }
        return idx == n;
    }

    public static void main(String[] args) {
        int[] org = {4, 1, 5, 2, 6, 3};
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(5, 2, 6, 3));
        matrix.add(Arrays.asList(4, 1, 5, 2));
        System.out.println(sequenceReconstruction(org, matrix));
    }
}
