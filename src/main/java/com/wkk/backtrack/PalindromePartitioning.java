package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 131 分割回文串
 * @author weikunkun
 * @since 2021/2/17
 */
public class PalindromePartitioning {
    // 1. 判断回文串的函数
    // 2. 回溯
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> out = new ArrayList<>();
        if (Objects.isNull(s) || "".equals(s)) {
            return result;
        }
        backtrack(result, out, s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> out, String str, int index) {
        if (index == str.length()) {
            result.add(new ArrayList<>(out));
        }

        for (int i = index; i < str.length(); i++) {
            if (!isPalindrome(str, index, i)) {
                continue;
            }
            out.add(str.substring(index, i + 1));
            backtrack(result, out, str, i + 1);
            out.remove(out.size() - 1);
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        if (Objects.isNull(str) || "".equals(str)) {
            return true;
        }
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
