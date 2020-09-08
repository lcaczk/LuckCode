package com.wkk.everyday.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：组合
 * <p>
 * 描述：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 思路：回溯（这个月是回溯月？？？）
 *
 * @author kongwiki@163.com
 * @since 2020/9/8 8:56 上午
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }
        List<Integer> out = new ArrayList<>();
        backtrack(res, out, 1, k, n);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> out, int start, int k, int n) {
        if (out.size() == k) {
            res.add(new ArrayList<>(out));
        }

        for (int i = start; i <= n; i++) {
            if (out.contains(i)) {
                continue;
            }
            out.add(i);
            backtrack(res, out, i + 1, k, n);
            out.remove(out.size() - 1);
        }
    }
}
