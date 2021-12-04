package com.wkk.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/7/17
 */
public class LC_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // map
        // dp
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        String tmp;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                tmp = s.substring(j, i);
                if (dp[j] && wordDict.contains(tmp)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> wordDick = new ArrayList<>(Arrays.asList("leet", "code"));
    }
}
