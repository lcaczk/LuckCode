package com.wkk.everyday.sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：组合总数和II
 * <p>
 * 描述：
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 示例：
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * <p>
 * 思路：本月是回溯月没跑了，都是一些经典的回溯问题
 *
 *
 * @author kongwiki@163.com
 * @since 2020/9/10 11:21 上午
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        List<Integer> out = new ArrayList<>();
        backtrack(candidates, res, out, 0, target);
        return res;
    }

    private void backtrack(int[] candidates ,List<List<Integer>> res, List<Integer> out, int start, int target) {
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(out));
        }
        for(int i = start; i<candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            out.add(candidates[i]);
            backtrack(candidates, res, out, i+1, target-candidates[i]);
            out.remove(out.size() - 1);
        }
    }
}
