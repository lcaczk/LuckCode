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

    public static boolean isMatchII(String s, String p){
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        for (int i = 0; i < s.length(); i++) {
            
        }



        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }
}
