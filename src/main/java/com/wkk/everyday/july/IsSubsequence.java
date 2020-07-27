package com.wkk.everyday.july;

/**
 * @Time: 2020/7/27上午7:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
