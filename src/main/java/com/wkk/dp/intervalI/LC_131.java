package com.wkk.dp.intervalI;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/5/25
 */
public class LC_131 {
    private List<List<String>> res = new ArrayList<>();
    private boolean[][] dp;
    private int N;
    private String s;
    public List<List<String>> partition(String s) {
        // 动归
        // dp[i][j] 区间i-j构成的字符串能够成为回文串
        // 如果是，添加 之后构造回溯dfs
        this.s = s;
        char[] chars = s.toCharArray();
        N = s.length();
        dp = new boolean[N][N];
        // 初始化
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }
        // 奇偶性
         for (int i = 0; i + 1 < N; i++) {
             dp[i][i+1] = chars[i] == chars[i+1];
         }

        for (int len = 3; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = false; // 说明 区间[i:j]不能构成回文串
                }
            }
        }
        // dfs
        Deque<String> tmp = new ArrayDeque<>();
        dfs(0, tmp);
        return res;
    }

    private void dfs(int starter, Deque<String> tmp) {
        if (starter == N){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = starter; j < N; j++){
            if (dp[starter][j]){
                tmp.addLast(s.substring(starter, j + 1));
                dfs(j+1, tmp);
                tmp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        LC_131 lc_131 = new LC_131();
        String s = "aab";
        lc_131.partition(s);
    }
}
