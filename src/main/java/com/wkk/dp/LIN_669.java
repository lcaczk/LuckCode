package com.wkk.dp;

import java.util.Arrays;

/**
 * 硬币个数
 * @author weikunkun
 * @since 2021/3/11
 */
public class LIN_669 {
    public int coinChange(int[] coins, int amount) {
        // write your code here
        // 暂时不考虑数据前的校验
        int[] res = new int[amount + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 遍历硬币集
            res[i] = Integer.MAX_VALUE;
            for (int num : coins) {
                if (i >= num && res[i-num] != Integer.MAX_VALUE) {
                    res[i] = Math.min(res[i-num] + 1, res[i]);
                }
            }
        }
        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];

    }

    public static void main(String[] args) {
        int[] coins = {5, 2, 1};
        LIN_669 lin_669 = new LIN_669();
        System.out.println(lin_669.coinChange(coins, 11));

    }
}
