package com.wkk.interview.bytedance2021.simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/3/27
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] visited = new int[N + 1];
        List<Integer>[] graph = new List[N + 1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        for (int i = 1; i <= N; ++i) {
            //当前点没有被访问过且染色失败，返回false
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) return false;
        }
        return true;
    }

    /**
     * @param graph   图
     * @param curr    当前处理的顶点
     * @param color   当前顶点即将被染的颜色
     * @param visited 记录顶点是否被访问过
     * @return 成功染色，返回true，失败染色返回false
     */
    public boolean dfs(List<Integer>[] graph, int curr, int color, int[] visited) {
        if (visited[curr] != 0) {
            return visited[curr] == color;
        }
        visited[curr] = color;
        for (int next : graph[curr]) {
            if (!dfs(graph, next, -color, visited)) return false;
        }
        return true;
    }


    /**
     * 广度遍历
     */
    public boolean possibleBipartitionII(int N, int[][] dislikes) {
        //v 表示从1 到 N 的节点，其各自的颜色，初始化为0， 两种颜色 1 和-1
        int[] v = new int[N + 1];
        //构造图
        List<Integer>[] graph = new List[N + 1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();
        //无向图
        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        for (int i = 1; i <= N; ++i) {
            if (v[i] != 0) continue;//已经染色的不需要再染色了
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            v[i] = 1;//染色1
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int next : graph[curr]) {
                    if (v[next] != 0) {//next如果是和curr一样的颜色，说明是同类，但是他们各自不喜欢，返回false
                        if (v[curr] == v[next]) return false;
                    } else {
                        q.offer(next);
                        v[next] = -v[curr];//翻转next的颜色为curr的相反数
                    }
                }
            }
        }
        return true;
    }
}
