package com.wkk.dfs.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/8/2
 */
public class LC_743 {
    // map key : node  value : [node, time];
    static Map<Integer, List<int[]>> map = new HashMap<>();

    public static int networkDelayTime(int[][] times, int n, int k) {

        for (int[] time : times) {
            int cur = time[0];
            int[] next = new int[2];
            next[0] = time[1]; // next node
            next[1] = time[2]; // time
            map.computeIfAbsent(cur, list -> new ArrayList<>()).add(next);
        }
        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;
        //dfs
        dfs(k, time);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (time[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, time[i]);
        }
        return max;
    }

    private static void dfs(int k, int[] time) {
        List<int[]> adj = map.getOrDefault(k, new ArrayList<>());
        for (int[] next : adj) {
            int nextAdj = next[0];
            int spend = next[1];
            if (time[nextAdj] > time[k] + spend) {
                time[nextAdj] = time[k] + spend;
                dfs(nextAdj, time);
            }
        }
    }

}
