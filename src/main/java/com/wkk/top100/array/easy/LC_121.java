package com.wkk.top100.array.easy;

/**
 * 买卖股票的最佳时机
 * @author kongwiki@163.com
 * @since 2021/2/6
 */
public class LC_121 {
    public int maxProfit(int[] prices) {
        // TODO 判空
        int min = prices[0];
        int max = 0;
        for(int price : prices) {
            min = Math.min(price, min);
            max = Math.max(max,(price - min));
        }
        return max;
    }
}
