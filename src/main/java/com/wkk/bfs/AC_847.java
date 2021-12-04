package com.wkk.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/3
 */
public class AC_847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int ord = sc.nextInt();
            int tar = sc.nextInt();
            adj.get(ord).add(tar);
        }
        cal(adj, n);
    }

    private static void cal(List<List<Integer>> adj, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        int count = 0;
        int cur;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur == n) {
                    break;
                }
                visited[cur] = true;
                for (int adjNode : adj.get(cur)) {
                    if (!visited[adjNode]) {
                        queue.offer(adjNode);
                        visited[adjNode] = true;
                    }
                }
            }
            count++;
        }
        System.out.println(count - 1);
    }
}
