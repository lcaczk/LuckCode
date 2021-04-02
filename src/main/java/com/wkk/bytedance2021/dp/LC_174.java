package com.wkk.bytedance2021.dp;

/**
 * 174 地下城游戏
 *
 * @author weikunkun
 * @since 2021/4/2
 */
public class LC_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        dp[rows-1][cols-1] = Math.max(1-dungeon[rows-1][cols-1], 1);
        for (int i = rows-2; i >= 0; i--) {
            dp[i][cols-1] = Math.max(1, dp[i+1][cols-1] - dungeon[i][cols-1]);
        }
        for (int i = cols-2; i >= 0; i--) {
            dp[rows-1][i] = Math.max(1, dp[rows - 1][i + 1] - dungeon[rows-1][i]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, min - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}

