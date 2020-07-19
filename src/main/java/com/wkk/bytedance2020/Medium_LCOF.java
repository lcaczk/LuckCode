package com.wkk.bytedance2020;

/**
 * @Time: 2020/7/19上午9:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_LCOF {
    public int cuttingRope(int n){
        if(n <= 3){
            if(n == 1){
                return 0;
            }else if(n == 2){
                return 1;
            }else {
                return 2;
            }
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        for(int i = 4; i<=n; i++){
            for(int k = 1; k <= i/2; k++){
                max = Math.max(dp[i-k] * dp[k], max);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
