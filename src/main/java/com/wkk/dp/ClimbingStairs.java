package com.wkk.dp;

/**
 * @Time: 2020/7/11上午10:12
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ClimbingStairs {
    public int climbStairsI(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public int climbStairsII(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int a = 1;
        int b = 2;
        int temp;
        for(int i = 3; i<=n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
