package com.wkk.simulation.lc;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/7/4
 */
public class LC_5801 {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] ans = new double[n];
        for (int i = 0; i < n; i++) {
            if (dist[i] % speed[i] != 0) {
                ans[i] = dist[i] / speed[i] + 1;
            } else {
                ans[i] = dist[i] / speed[i];
            }
        }
        Arrays.sort(ans);
        int rs = 0;
        for (int i = 0; i < n; i++) {
            if (ans[i] > i) {
                rs += 1;
            } else {
                return rs;
            }
        }
        return rs;

    }

    public static void main(String[] args) {
        int[] dis = {3, 5, 7, 4, 5};
        int[] speed = {2, 3, 6, 3, 3};
        System.out.println(eliminateMaximum(dis, speed));
    }
}
