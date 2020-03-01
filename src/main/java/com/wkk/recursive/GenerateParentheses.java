package com.wkk.recursive;

import java.util.List;

/**
 * @Time: 20-2-29下午5:31
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        _generate(0, 2 * n, "");
        return null;
    }

    private static void _generate(int level, int max, String s) {
        // terminator
        if (level > max) {
            System.out.println(s);
            return;
        }

        // process
//        String s1 = s + "(";
//        String s2 = s + ")";
        // drill down
        _generate(level + 1, max, s + "(");
        _generate(level + 1, max, s + ")");

        // reverse states
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
