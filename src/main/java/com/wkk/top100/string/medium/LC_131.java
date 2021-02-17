package com.wkk.top100.string.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * 131 分割回文串
 * @author weikunkun
 * @since 2021/2/17
 */
public class LC_131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, stack, res);
        return res;
    }

    /**
     * @param s
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    private void backtracking(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        if (Objects.isNull(str)) {
            return true;
        }
        char[] chars = str.toCharArray();
        while(start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        LC_131 lc_131 = new LC_131();
        System.out.println(s.substring(0, 1));
    }
}
