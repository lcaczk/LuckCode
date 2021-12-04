package com.wkk.dp.timeSequences;

/**
 * @author weikunkun
 * @since 2021/8/18
 */
public class LC_552 {
    private int MOD = (int) 1e9 + 7;

    /**
     * 状态dp
     * @param n
     * @return
     */
    public int checkRecordII(int n) {
        long[][][] dp = new long[n][2][3];
        // 初始值
        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        dp[0][0][1] = 1;

        for (int i = 1; i < n; i++) {
            // 本次填入P，分成前一天累计了0个A和1个A两种情况
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD;
            // 本次填入A，前一天没有累计A都能转移过来
            // 这行可以与上面一行合并计算，为了方便理解，我们分开，下面会合并
            dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            // 本次填入L，前一天最多只有一个连续的L，分成四种情况
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        }

        // 计算结果，即最后一天的所有状态相加
        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % MOD;
            }
        }
        return (int) ans;
    }

    /**
     * dfs
     *
     * @param n
     * @return
     */
    public int checkRecordI(int n) {
        return dfsI(0, n, 0, 0);
    }

    private int dfsI(int day, int n, int absent, int late) {
        if (day >= n) {
            return 1;
        }
        int ans = 0;
        ans = (ans + dfsI(day + 1, n, absent, 0)) % MOD;
        if (absent < 1) {
            ans = (ans + dfsI(day + 1, n, 1, 0)) % MOD;
        }
        if (late < 2) {
            ans = (ans + dfsI(day + 1, n, absent, late + 1)) % MOD;
        }

        return ans;
    }

    /**
     * dfs 记忆化递归
     *
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        int[][][] memo = new int[n][2][3];
        return dfs(0, n, 0, 0, memo);
    }

    private int dfs(int day, int n, int absent, int late, int[][][] memo) {
        if (day >= n) {
            return 1;
        }
        // 相同的状态计算过了直接返回
        if (memo[day][absent][late] != 0) {
            return memo[day][absent][late];
        }


        int ans = 0;
        // present 随意放
        ans = (ans + dfs(day + 1, n, absent, 0, memo)) % MOD;
        // absent 只能放1个
        if (absent < 1) {
            ans = (ans + dfs(day + 1, n, 1, 0, memo)) % MOD;
        }
        // late 最多放连续的两个
        if (late < 2) {
            ans = (ans + dfs(day + 1, n, absent, late + 1, memo)) % MOD;
        }

        // 记录每一个状态的计算结果
        memo[day][absent][late] = ans;

        return ans;
    }
}
