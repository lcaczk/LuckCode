package com.wkk.bytedance2021.array;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 丑数II
 * 思路 动态规划
 * 注意使用 条件判断 使用 if ？ else if
 * 对于 6 或则 10 或者 15 这种
 * 使用else if 可能会使得两个因子的倍数都+1 根据题意，每次只能有一个因子+1
 * 所以使用if
 * @author weikunkun
 * @since 2021/3/22
 */
public class LC_264 {
    public static int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        // 思路
        // 动态规划
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[a]*2,dp[b] * 3), dp[c] * 5);
            if (dp[i] == dp[a] * 2) {
                a++;
            } else if (dp[i] == dp[b] * 3) {
                b++;
            } else if (dp[i] == dp[c] * 5) {
                c++;
            }
        }
        return dp[n-1];
    }

    private BigDecimal muli(int[] array) {
        BigDecimal sum = new BigDecimal(1);
        for (int num : array) {
            BigDecimal decimal = new BigDecimal(num);
            sum = decimal.multiply(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        nthUglyNumber(n);
        List<Integer> list = new ArrayList<>();;
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        BigDecimal a = new BigDecimal(1);

    }
}
