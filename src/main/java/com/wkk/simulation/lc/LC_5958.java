package com.wkk.simulation.lc;

/**
 * @author weikunkun
 * @since 2021/12/19
 */
public class LC_5958 {
    public long getDescentPeriods(int[] prices) {
        // 差分 + 寻找连续的-1
        int n = prices.length;
        int[] diff = new int[n];
        long res = n;

        for (int i = 1; i < n; i++) {
            diff[i] = prices[i] - prices[i - 1];
        }

        // 寻找连续的-1
        for (int i = 1; i < n; ) {
            int j = i;
            while (j < n && diff[j] == -1) {
                j++;
            }

            if (j != i) {
                long len = j - i;
                res += (len + 1) * len / 2;
            }
            i = j;
        }


        return res;
    }
}
