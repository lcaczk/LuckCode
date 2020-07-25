package com.wkk.bytedance2020.lc.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 2020/7/24上午10:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() == s2.length() && !s1.equals(s2)) {
            return false;
        }
        List<String> res = new ArrayList<>();
        List<Character> out = new ArrayList<>();
        int len = s1.length();
        backtrack(s1, res, out, len);
        for (String str : res) {
            if (s2.contains(str)) {
                return true;
            }
        }
        return false;

    }

    private static void backtrack(String s, List<String> res, List<Character> out, int len) {
        if (out.size() == len) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : out) {
                sb.append(ch);
            }
            res.add(sb.toString());
            out = new ArrayList<>();
            return;
        }
        for (int i = 0; i < len; i++) {
            if (out.contains(s.charAt(i))) {
                continue;
            }
            out.add(s.charAt(i));
            backtrack(s, res, out, len);
            out.remove(out.size() - 1);
        }
    }
}
