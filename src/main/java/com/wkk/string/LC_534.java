package com.wkk.string;

import java.util.List;

/**
 * @author weikunkun
 * @since 2021/7/31
 */
public class LC_534 {
    private int n;
    private String s;
    public String findLongestWord(String s, List<String> dictionary) {
        // 思路 ： 是否是子串 然后获取最大
        this.s = s;
        this.n = s.length();
        String ans = "";
        for (String str : dictionary) {
            if (ans.length() > str.length() || (ans.length() == str.length() && ans.compareTo(str) <= 0)) {
                continue;
            }
            if (isSub(str)) {
                ans = str;
            }
        }
        return ans;
    }

    private boolean isSub(String small) {
        int i = 0;
        int j = 0;
        int m = small.length();
        while (i < n && j < m) {
            if (small.charAt(j) == s.charAt(i)) {
                j++;
            }
            i++;
        }
        return j == m;
    }
}
