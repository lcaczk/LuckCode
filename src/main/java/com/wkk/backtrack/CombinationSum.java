package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-3-26上午8:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CombinationSum {
    private List<List<Integer>> results = new ArrayList<List<Integer>>();
    private List<Integer> curren = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        if(candidates == null){
            return results;
        }
        backtrack(0, candidates, target, curren);
        return results;
    }

    private void backtrack(int start, int[] candidates, int target, List<Integer> out){
        if(target < 0){
            return;
        }
        if(target == 0){
            results.add(new ArrayList<>(out));
        }
        for (int i = start; i < candidates.length; i++) {
            out.add(candidates[i]);
            backtrack(i, candidates, target-candidates[i], curren);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {

    }
}
