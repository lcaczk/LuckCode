package com.wkk.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用最小花费爬楼梯
 * 思路：
 * 爬楼梯的延伸
 *
 * @author weikunkun
 * @since 2021/4/12
 */
public class LC_746 {
    /**
     * 思路
     * 确定dp数组和下标含义
     * dp[i]代表 到达第i个位置所需要消耗的最小花费， 不管怎样，都是从前面一阶台阶上来、前面两阶台阶上来 上来之后加上当前台阶的花费，方程如下：
     * dp[i] = Min(dp[i-1],dp[i-2]) + cost[i]
     * dp[0] = cost[0];
     * dp[1] = cost[1];  // 这里是为了方便后序的循环，实际返回的时候还是要确定 min(dp[n-1], dp[n])， 因为最后一阶台阶不需要加上当前的cost[n]
     * dp[1] = min(cost[0], cost[1]) + 对应的cost消耗
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 有问题 既然定义的是dp 到达第i个位置 消耗的最小价值
     * 考虑到无后效行，应该考虑如何从前面的状态转移过来
     * @param cost
     * @return
     */
    public static int minCostClimbingStairsI(int[] cost) {
        // 爬楼梯 + 消耗
        // dp 到达第i个位置 消耗的最小价值
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i + j > n) {
                    continue;
                }
                int next = i + j;
                dp[next] = Math.min(dp[next], dp[i] + cost[next - 1]);
            }
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList());
        int[] costs = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairsI(costs));
    }
}
