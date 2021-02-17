package com.wkk.top100.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39 组合总和
 * @author weikunkun
 * @since 2021/2/16
 */
public class LC_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return result;
        }
        backtrack(result, out, candidates, 0, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> out, int[] candidates,  int currentSum, int target, int start) {
        if (currentSum == target) {
            result.add(new ArrayList<>(out));
            return;
        }
        // 剪枝优化第一种方式
        if (currentSum > target) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            out.add(candidates[i]);
            currentSum += candidates[i];
            backtrack(result, out, candidates, currentSum, target, i);
            currentSum -= candidates[i];
            out.remove(out.size()-1);
        }
    }

    /**
     * 有些细节出现问题
     * @param result
     * @param out
     * @param candidates
     * @param currentSum
     * @param target
     * @param start
     */
    private void backtrackII(List<List<Integer>> result, List<Integer> out, int[] candidates,  int currentSum, int target, int start) {
        if (currentSum == target) {
            result.add(new ArrayList<>(out));
            return;
        }
        // 剪枝方式第二种
        for(int i = start; i < candidates.length && currentSum + candidates[i] <= target; i++) {
            out.add(candidates[i]);
            currentSum += candidates[i];
            backtrack(result, out, candidates, currentSum, target, i);
            currentSum -= candidates[i];
            out.remove(out.size()-1);
        }
    }
}
