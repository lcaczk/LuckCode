package com.wkk.top100.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 括号生成
 * 思路：回溯
 * 横向 for循环
 * 纵向 递归
 * @author weikunkun
 * @since 2021/2/16
 */
public class LC_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        backtrack(result, sb, n, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int left, int right) {
        // 当left == 0 && right ==0时，终止
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        // 分支条件 1 left > 0 right > 0
        // 分支条件 2 left num < right num
        if (left > right) {
            return;
        }
        if (left > 0) {
            sb.append("(");
            backtrack(result, sb, left-1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right > left) {
            sb.append(")");
            backtrack(result, sb, left, right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
