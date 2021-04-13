package com.wkk.bytedance2021.dp;

/**
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 * 思路：类似左神的树上的动归问题
 * @author weikunkun
 * @since 2021/4/13
 */
public class 圆环走法 {
    /**
     * @param n 位置数量
     * @param k 走的步数
     * @return
     */
    public static int backToOrigin(int n, int k) {
        // 定义dp数组、明确索引下标从点j 走k步到达原点0的方法数
        // dp[i][j] 表示从点j走i步到达原点0的方法数
        // 递推公式
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
        // 因为是环，所以会导致索引问题
        // dp[i][j] = dp[i-1][(j-1+n)%n] + dp[i-1][(j+1)%n];
        int[][] dp = new int[k][n];
        dp[0][0] = 1;
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i-1][(j-1+n)%n] + dp[i-1][(j+1)%n];
            }
        }
        return dp[k-1][0];
    }

    public static void main(String[] args) {
        backToOrigin(6, 6);
    }
}


