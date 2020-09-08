package com.wkk.everyday.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：组合总数
 * <p>
 * 描述：给定一个无重复元素的数组
 * candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * <p>
 * 思路：回溯 直接AC
 *
 * @author kongwiki@163.com
 * @since 2020/9/9 7:44 上午
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        backtrack(candidates, res, out, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, List<List<Integer>> res, List<Integer> out, int target, int start) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            out.add(candidates[i]);
            backtrack(candidates, res, out, target - candidates[i], i);
            out.remove(out.size() - 1);
        }
    }
}
