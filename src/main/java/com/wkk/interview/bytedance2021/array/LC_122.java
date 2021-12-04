package com.wkk.interview.bytedance2021.array;

/**
 * 122 买卖股票的最佳时机II
 * @author weikunkun
 * @since 2021/3/18
 */
public class LC_122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return -1;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}
