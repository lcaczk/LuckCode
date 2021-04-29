package com.wkk.dp.bag;

/**
 * 01背包问题
 *
 * @author weikunkun
 * @since 2021/4/28
 */
public class ZeroOneBag {
    // dp[i][j] 其中一维代表当前「当前枚举到哪件物品」，
    //          另外一维「现在的剩余容量」，
    //          数组装的是「最大价值」。
    // 考虑前i件物品，当前容量为C的条件下，装下的最大价值

    /**
     * 挺复杂的，还需要考虑到数组下标问题
     * 物品个数为N 价值为C 数组从0开始，所以应该初始化一个dp[N][C+1]的二维数组
     * 空间优化，可以考虑压缩数组
     *
     * @param N N件物品
     * @param C 背包总的容量为C
     * @param v 每个物品的体积v[i]
     * @param w 每个物品的价值w[i]
     * @return
     */
    public int maxValue(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[N][C + 1];
        //考虑前i件物品，使用容量不超过C的条件下的背包最大价值。
        // 不失一般性的，我们只需要考虑第i件物品如何选择即可，
        //      对于第i件物品，我们有「选」和「不选」两种决策。
        //          「不选」其实就是dp[i-1][c]等效于我们只考虑前i-1件物品，当前容量为c的情况下的最大价值。
        //          「选」就意味着我们消耗了v[i]的体积，获取w[i]的价值，那么留给前i-1件物品的容量为c-v[i]
        //               最大价值也就是 d[i-1][c-v[i]] + w[i];
        // 先处理第一行
        // dp[0][j] 只有一件物品，不同容量能够装下的最大价值
        for (int i = 0; i <= C; i++) {
            dp[0][i] = i >= v[0] ? w[0] : 0;
        }
        // 先遍历物品，再遍历容量
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                // 不选当前的物品
                int n = dp[i - 1][j];
                // 选择该物品，前提是该物品能够放下背包中剩余的容量
                int y = j > v[i] ? dp[i - 1][j - v[i]] + w[i] : 0;
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[N - 1][C];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
    }
}
