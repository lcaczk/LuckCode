package com.wkk.simulation.mt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/9
 */
public class 小团无路可逃 {

    private static List<List<Integer>> e;

    public static void main(String[] args) {
        int n, x, y;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        e = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            e.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            e.get(u).add(v);
            e.get(v).add(u);
        }
        int ans = 0;
        int[] dis_x = new int[n + 1];
        int[] dis_y = new int[n + 1];
        dis_y[0] = dis_x[0] = -1;
        dfs(x, 0, dis_x);
        dfs(y, 0, dis_y);
        for (int i = 1; i <= n; i++)
            if (dis_y[i] < dis_x[i])
                ans = Math.max(ans, dis_x[i]);
        System.out.println(ans);
    }

    private static void dfs(int u, int f, int[] dis) {
        dis[u] = dis[f] + 1;
        int size = e.get(u).size();
        for (int i = 0; i < size; i++) {
            int v = e.get(u).get(i);
            if (v == f) continue;
            dfs(v, u, dis);
        }
    }
}
