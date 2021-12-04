package com.wkk.simulation.newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/8
 */
public class 跳石板 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int starter = sc.nextInt();
        int end = sc.nextInt();
        // 兑换硬币问题
        System.out.println(genNums(starter, end));
    }

    private static int genNums(int starter, int end) {
        int[] dp = new int[end + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[starter] = 0;
        for (int i = starter; i <= end; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int step : getGCD(i)) {
                int idx = i + step;
                int cout = dp[i] + 1;
                if (idx > end) {
                    continue;
                }
                dp[idx] = Math.min(dp[idx], cout);
            }
        }
        return dp[end] == Integer.MAX_VALUE ? -1 : dp[end];
    }

    /**
     * 错误： 明确dp下标的意义
     * @param starter
     * @param end
     * @return
     */
    private static int genNumsII(int starter, int end) {
        int[] dp = new int[end + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[starter] = 0;
        for (int i = starter + 1; i <= end; i++) {
            for (int step : getGCD(i)) {
                if (i - step < starter || dp[i-step] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i - step] + 1, dp[i]);
            }
        }
        return dp[end] == Integer.MAX_VALUE ? -1 : dp[end];
    }

    private static List<Integer>  getGCD(int N) {
        List<Integer> res = new ArrayList<>();
        final int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (N % i == 0) {
                res.add(N / i);
                res.add(i);
            }
        }
        return res;
    }
}
