package com.wkk.top100.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/2/17
 */
public class LC_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (candidates.length == 0 || null == candidates) {
            return result;
        }
        // 有重复的元素，需要剔除
        Arrays.sort(candidates);
        backtrack(result, out, candidates, target, 0, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> out, int[] candidates,int target, int currentSum, int index) {
        if (currentSum == target) {
            result.add(new ArrayList<>(out));
            return;
        }
        if (currentSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            out.add(candidates[i]);
            currentSum += candidates[i];
            backtrack(result, out, candidates, target, currentSum, i+1);
            currentSum -= candidates[i];
            out.remove(out.size()-1);
        }
    }
}
