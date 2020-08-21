package com.wkk.everyday.july;

/**
 * @Time: 2020/7/10上午9:53
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        if(prices.length<2 || prices == null){
            return 0;
        }
        int n = prices.length;
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        f[1][0] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][2] - prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][1], f[i-1][2]);
        }
        return Math.max(f[n-1][1], f[n-1][2]);

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 2};
        int i = maxProfit(a);
        System.out.println(i);
    }
}
