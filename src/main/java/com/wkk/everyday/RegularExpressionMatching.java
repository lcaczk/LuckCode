package com.wkk.everyday;

import java.util.regex.Pattern;

/**
 * @Time: 2020/6/20上午9:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean matches = Pattern.matches(p, s);
        return matches;
    }

    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        boolean match = matching.isMatch("aaa", "a*");
        System.out.println(match);
    }
}
