package com.wkk.weekcompete;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/4/18
 */
public class LC_5735 {
    /**
     * 错误
     * @param costs
     * @param coins
     * @return
     */
    public static int maxIceCream(int[] costs, int coins) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        Arrays.sort(costs);
        int num = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins - costs[i] >= 0) {
                num++;
            }
            coins -= costs[i];
        }
        return num;

    }

    public int maxIceCreamII(int[] costs, int coins) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        Arrays.sort(costs);
        int num = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins < costs[i]) {
                return num;
            }
            coins -= costs[i];
            num += 1;
        }
        return num;

    }

    public static void main(String[] args) {
        int coins = 20;
    }
}
