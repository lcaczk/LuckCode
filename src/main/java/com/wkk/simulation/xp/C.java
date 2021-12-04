package com.wkk.simulation.xp;

/**
 * @author weikunkun
 * @since 2021/9/6
 */
public class C {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param V int整型 货车的容量
     * @param item int整型一维数组 每个货物占用的体积
     * @return int整型
     */
    public int bestFit(int V, int[] item) {
        // write code here
        int n = item.length;
        int[] dp = new int[V + 1];
        for (int i = 0; i < n; i++) {
            for (int j = V; j >= item[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - item[i]] + item[i]);
            }
        }
        return V - dp[V];
    }


}
