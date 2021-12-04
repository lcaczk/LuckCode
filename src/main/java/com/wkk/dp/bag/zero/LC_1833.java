package com.wkk.dp.bag.zero;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/7/2
 */
public class LC_1833 {
    // 超时
    public int maxIceCream(int[] costs, int coins) {
        // 0 - 1 背包
        // 容量为j的背包，装入前i物品的最大数量
        int n = costs.length;
        int[][] dp = new int[n][coins + 1];
        // 初始化 第一个物品，
        for (int i = 0; i <= coins; i++) {
            dp[0][i] = i >= costs[0] ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= coins; j++) {
                int no = dp[i - 1][j];
                int yes = j >= costs[i] ? dp[i - 1][j - costs[i]] + 1 : 0;
                dp[i][j] = Math.max(no, yes);
            }
        }
        return dp[n - 1][coins];
    }

    // 贪心更简单些
    public int maxIceCreamII(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        for(int num : costs) {
            if (coins - num < 0) {
                break;
            }
            coins -= num;
            sum++;
        }
        return sum;
    }
}
