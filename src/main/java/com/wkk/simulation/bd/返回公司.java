package com.wkk.simulation.bd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/19
 */
public class 返回公司 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        while (group-- > 0) {
            int n = sc.nextInt();
            int e = sc.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.get(x).add(y);
                list.get(y).add(x);
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            int step = 2;
            boolean ans = false;
            while (step > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int curIdx = queue.poll();
                    for (Integer nextIdx : list.get(curIdx)) {
                        if (nextIdx == n) {
                            ans  = true;
                            break;
                        }
                        queue.offer(nextIdx);
                    }
                }
                step--;
            }

            if (ans) {
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");

            }

        }

    }

    private static int bfs(int[][] graph, int n, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true; // 位置1访问
        queue.offer(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            if (cur == n) {
                return count;
            }
            for (int nextIdx = 1; nextIdx <= n; nextIdx++) {
                if (!visited[nextIdx] && graph[cur][nextIdx] == 1) {
                    // 两顶点相连
                    visited[nextIdx] = true;
                    queue.offer(nextIdx);
                }
            }
        }
        return count;

    }

    private static boolean dfs(int[][] graph, int idx, boolean[] visited, int count, int target) {
        visited[idx] = true;
        count++;
        if (count == 2 && idx != target) {
            return false;
        } else if (count == 2 && idx == target) {
            return true;
        }
        boolean res = false;
        for (int adjIdx : graph[idx]) {
            if (!visited[idx] && graph[idx][adjIdx] == 1) {
                res = dfs(graph, adjIdx, visited, count + 1, target);
            }
        }
        return res;

    }

}
