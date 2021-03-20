package com.wkk.bytedance2021.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/3/20
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
}
