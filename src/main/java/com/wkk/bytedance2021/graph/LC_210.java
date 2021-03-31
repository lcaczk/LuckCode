package com.wkk.bytedance2021.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210 课程表II
 * @author weikunkun
 * @since 2021/3/27
 */
public class LC_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 相当于记录拓扑排序的过程
        if (numCourses == 0 && (prerequisites == null || prerequisites.length == 0 ||prerequisites[0].length == 0)) {
            return new int[1];
        }
        // 一次判断
        if (numCourses > 0 && prerequisites.length == 0) {
            int i = 0;
            int[] temp = new int[numCourses];
            while (i < numCourses) {
                temp[i++] = i-1;
            }
            return temp;
        }
        int[] res = new int[numCourses];
        int[] degree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 入度数组 + 构建邻接矩阵
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            adj.get(pre).add(cur);
            degree[cur]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            numCourses--;
            res[i++] = curNode;
            for (int node : adj.get(curNode)) {
                if (--degree[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        return numCourses == 0 ? res : new int[0];
    }

    public static void main(String[] args) {
        LC_210 lc_210 = new LC_210();
        int[][] matrix = {};
        lc_210.findOrder(4,matrix);
    }
}
