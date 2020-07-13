package com.wkk.everyday.july;

import java.util.Arrays;

/**
 * @Time: 2020/7/12上午9:03
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DungeonGame {
    // 从左到右硬算
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length -1;
        int n = dungeon[0].length - 1;
        if(m == 0 && n == 0){
            if(dungeon[m][n] > 0){
                return 1;
            }else {
                return Math.abs(dungeon[m][n]) + 1;
            }
        }
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = dungeon[0][0];
        for(int i = 1; i<=m; i++){
            dp[i][0] = dungeon[i][0] + dp[i-1][0];
        }
        for(int i = 1; i<=n; i++){
            dp[0][i] = dungeon[0][i] + dp[0][i-1];
        }
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                int top = Math.abs(dp[i-1][j] - dungeon[i][j]);
                int left = Math.abs(dp[i][j-1] - dungeon[i][j]);
                dp[i][j] = Math.min(top, left)==top? (dp[i-1][j] + dungeon[i][j]) : (dp[i][j-1] + dungeon[i][j]);
            }
        }
        return dp[m][n] > 0 ? 1 : Math.abs(dp[m][n]) + 1;
    }

    public static int calculateMinimumHPII(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };
        calculateMinimumHPII(matrix);


    }

}
