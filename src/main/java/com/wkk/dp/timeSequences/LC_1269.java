package com.wkk.dp.timeSequences;

/**
 * 停在原地的方案数量
 * @author weikunkun
 * @since 2021/5/13
 */
public class LC_1269 {
    private int mod = 1000000007;

    /**
     * 时间序列模型问题
     * 上一轮有三种状态： 左跳  不跳  右跳
     *
     * 当前轮有三种状态： 左跳  不跳  右跳
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {
        // 思路 在一个绳子上
        // 从原点出发 每次可以左右移动，但是不能越过0和arryLen
        // 经过i步之后，到达位置j的方案数量
        long[][] dp = new long[steps + 1][steps / 2 + 2];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < steps / 2 + 1; j++) {
                if (j == 0) { // 在位置0
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j+1]) % mod;
                } else if (j == arrLen - 1) { // 在位置len
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % mod;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }
        return (int)dp[steps][0];
    }

    /**
     * 超出时间限制
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWaysII(int steps, int arrLen) {
        // 思路 在一个绳子上
        // 从原点出发 每次可以左右移动，但是不能越过0和arryLen
        // 经过i步之后，到达位置j的方案数量
        long[][] dp = new long[steps + 1][arrLen];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < arrLen; j++) {
                if (j == 0) { // 在位置0
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j+1]) % mod;
                } else if (j == arrLen - 1) { // 在位置len
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % mod;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }
        return (int)dp[steps][0];
    }

}
