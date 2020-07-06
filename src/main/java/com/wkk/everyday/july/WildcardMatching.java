package com.wkk.everyday.july;


import java.util.regex.Pattern;

/**
 * @Time: 2020/7/5上午9:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        return Pattern.matches(p, s);
    }

    public static boolean isMatchII(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 仅做p的第一个判断 为* 则dp[0][1] = true
        // 否则 dp[0][1] = false;
        // 不适用直接判断 主要是防止过多的基础判断
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        System.out.println("sdds");
        return dp[m][n];


    }

    // 错误
    public static boolean isMatchIII(String s, String p){
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if(p.charAt(i-1) == '*'){
                dp[i] = true;
            }else {
                break;
            }
        }

        dp[0] = true;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1) == '*'){
                    dp[j] = dp[j] || dp[j-1];
                }
                else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[j] = dp[j-1];
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        boolean match = isMatchIII(s, p);
        System.out.println(match);
    }
}
