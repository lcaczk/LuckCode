package com.wkk.array;

/**
 * @Time: 20-2-23下午6:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ClimbingStairs {
    public static int climbStairs(int n){
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1; dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int i = ClimbingStairs.climbStairs(3);
        System.out.println(i);
    }
}
