package com.wkk.bytedance2020;

/**
 * @Time: 2020/7/19上午7:43
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Easy_BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        // 动归
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for(int i = 1; i<prices.length; i++){
            dp[i] = Math.max(dp[i-1], prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int i = maxProfit(a);
        System.out.println(i);
    }
}
