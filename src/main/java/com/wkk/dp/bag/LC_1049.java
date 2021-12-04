package com.wkk.dp.bag;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/6/8
 */
public class LC_1049 {
    public static int lastStoneWeightII(int[] stones) {
        // 0 - 1背包
        int N = stones.length;
        int sum = Arrays.stream(stones).sum();
        int half = sum / 2;
        // 前i个物品放入容量为j的背包中
        int[][] dp = new int[N + 1][half + 1];
        // 初始化
        // 1个物品放入容量为i的背包
        for (int i = 0; i <= half; i++) {
            dp[1][i] = i >= stones[0] ? stones[0] : 0;
        }

        for (int i = 1; i <= N; i++) { // 物品
            for (int j = 0; j <= half; j++) { // 容量
                int n = dp[i - 1][j];
                int y = j >= stones[i - 1] ? dp[i - 1][j - stones[i - 1]] + stones[i - 1] : 0;
                dp[i][j] = Math.max(n, y);
            }
        }
        return sum - 2 * dp[N][half];
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        lastStoneWeightII(stones);
        System.out.println(-6 % 4);
    }
}
