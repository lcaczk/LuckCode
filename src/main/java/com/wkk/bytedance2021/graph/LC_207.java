package com.wkk.bytedance2021.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 207 课程表
 *
 * @author weikunkun
 * @since 2021/3/27
 */
public class LC_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 使用图的存储结构： 邻接表
        // 入度数组
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        int[] inDegrees = new int[numCourses];
        // 邻接表
        List<List<Integer>> adj = new ArrayList<>();
        // 初始化 邻接表
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 完善入度数组和邻接表
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[1];
            int cur = prerequisite[0];
            inDegrees[cur]++;
            adj.get(pre).add(cur);
        }
        // 先将入度为0的节点放入
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        // 遍历，将入度为0的顶点入队
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            numCourses--;
            for (Integer adjNode : adj.get(cur)) {
                if (--inDegrees[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }

        return numCourses == 0;
    }


}
