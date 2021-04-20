package com.wkk.array;

/**
 * @Time: 20-4-12上午9:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum ;
    }

    public static void main(String[] args) {
    }
}
