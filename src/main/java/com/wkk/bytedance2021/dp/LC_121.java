package com.wkk.bytedance2021.dp;

import java.util.Objects;

/**
 * 121 买卖股票的最佳时机
 * @author weikunkun
 * @since 2021/3/14
 */
public class LC_121 {
    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length < 2) {
            return 0;
        }
        // 思路：
        // 每次用当前元素值 - 之前记录中最小的价格
        int max = Integer.MIN_VALUE;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            max = Math.max(max, (prices[i] - min));
        }
        return max;
    }
}
