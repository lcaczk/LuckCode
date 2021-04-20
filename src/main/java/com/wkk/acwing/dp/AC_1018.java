package com.wkk.acwing.dp;

/**
 * @author weikunkun
 * @since 2021/4/20
 */
public class AC_1018 {
    public static int strStr(String haystack, String needle) {
        if (null == needle || needle.length() == 0) {
            return 0;
        }
        if (null == haystack || haystack.length() == 0) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        // O(n^2)
        int i = 0;
        while (i < haystack.length()) {
            int temp = i;
            int j = 0;
            while(j < needle.length() && (haystack.charAt(i) == needle.charAt(j))) {
                i++;
                j++;
            }
            if (j == needle.length()) {
                return temp;
            } else {
                i = temp + 1;
            }
        }

        return -1;
    }

    public int strStrII(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr("mississippi", "issipi") ;
    }
}
