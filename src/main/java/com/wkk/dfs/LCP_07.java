package com.wkk.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/7/1
 */
public class LCP_07 {
    private int target;
    private int count = 0;
    public int numWays(int n, int[][] relation, int k) {
        // bfs 、dfs
        target = n - 1;
        // dfs吧
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] rel : relation) {
            adj.get(rel[0]).add(rel[1]);
        }
        dfs(adj, k, 0);
        return count;
    }

    private void dfs (List<List<Integer>> adj, int k, int idx) {
        if (k == 0 && idx == target) {
            count++;
        }
        if (k <= 0) {
            return;
        }
        List<Integer> next = adj.get(idx);
        for (int num : next) {
            dfs(adj, k - 1, num);
        }
    }
}
