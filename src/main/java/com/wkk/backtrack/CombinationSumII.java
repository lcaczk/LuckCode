package com.wkk.backtrack;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-3-26上午8:31
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CombinationSumII {
    // 有重复项
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> out = new ArrayList<>();
        backtrack(0, out, candidates, target);
        return results;

    }

    private void backtrack(int start, List<Integer> out, int[] candidates, int target) {
        if(target < 0){
            return;
        }
        if(target == 0){
            results.add(new ArrayList<>(out));
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] == candidates[i-1] && i> start){
                continue;
            }
            out.add(candidates[i]);
            backtrack(i+1, out, candidates, target-candidates[i]);
            out.remove(out.size()-1);
        }
    }
}
