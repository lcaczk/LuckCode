package com.wkk.top100.string.medium;

/**
 * 647 回文子串
 * 1. 中心拓展法 每次都记不住 难顶
 * 2. 马拉车算法
 * @author weikunkun
 * @since 2021/2/18
 */
public class LC_647 {
    /**
     * 中心拓展法
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "abc";
        LC_647 lc_647 = new LC_647();
        System.out.println(lc_647.countSubstrings(a));
    }


}
