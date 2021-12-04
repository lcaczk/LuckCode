package com.wkk.dp.bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/11
 */
public class LC_279 {
    /**
     * 0-1背包
     * 先求出<n的所有完全平方数
     * 然后dp[i][j] 前i个完全平方数组成n的最小数量
     * 前缀和 不行，因为完全平方数的数量不定
     *
     * @param n
     * @return
     */
    static int INF = 0x3f3f3f3f;
    public static int numSquares(int n) {
        // 完全背包
        int[] nums = genTotalSuqer(n);
        int len = nums.length;
        // 前i个元素放入容量为j的背包中，最少数量
        int[][] dp = new int[len + 1][n + 1];
        // 初始化
        // 1 0个元素 j容量 +∞
        // 2 n个元素 0容量 0
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * x <= j; k++) {
                    if (dp[i - 1][j - k * x] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * x] + k);
                    }
                }
            }
        }
        return dp[len][n];

    }

    private static int[] genTotalSuqer(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int rst = (int) Math.sqrt(i);
            if (rst * rst == i) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
