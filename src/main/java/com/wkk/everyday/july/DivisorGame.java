package com.wkk.everyday.july;

/**
 * @Time: 2020/7/24上午9:24
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DivisorGame {
    public static boolean divisorGameII(int N){
        // 根据总结, 得到偶数极为获胜
        return N % 2 == 0;
    }

    public static boolean divisorGame(int N) {
        if(N < 3){
            if(N==1){
                return false;
            }else if(N==2){
                return true;
            }
        }
        boolean[] dp = new boolean[N + 1];
        dp[2] = true;
        for (int i = 4; i <= N; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if ((i % j == 0 && dp[j])) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(6));
    }
}
