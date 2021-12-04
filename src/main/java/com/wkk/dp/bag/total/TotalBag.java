package com.wkk.dp.bag.total;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 完全背包
 * 在0-1背包的基础上，增加了每个物品可以选择多次的特定（容量允许的情况下）
 *
 * @author weikunkun
 * @since 2021/4/28
 */
public class TotalBag {
    /**
     * 完全背包未能
     * @param N 物品数量
     * @param C 背包容量
     * @param v v[i]代表第i个物品的体积
     * @param w w[i]代表第i个物品的价值
     * @return
     */
    public int maxValue(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[N][C+1];
        // 只有一个物品时能获取的最大价值
        for (int i = 0; i <= C; i++) {
            int max = i / v[0];
            dp[0][i] = max * w[0];
        }

        // 出来剩余物品
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                // 不拿当前物品
                int n = dp[i-1][j];
                // 拿当前物品
                int y = 0;
                for (int k = 1; ; k++) {
                    if (j < v[i] * k) {
                        break;
                    }
                    y = Math.max(y, dp[i-1][j - k * v[i]] + k * w[i]);
                }
                dp[i][j] = Math.max(y,n);
            }
        }
        return dp[N-1][C];
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-1, 0, 1));
    }
}
