package com.wkk.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-3-3下午7:28
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CombinationSumII {
    private static List<List<Integer>> results = new ArrayList<List<Integer>>();
    private static List<Integer> out = new ArrayList<Integer>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0){
            return results;
        }
        Arrays.sort(candidates);
        dfs(0, results, out, candidates, target);
        return results;
    }

    private static void dfs(int start, List<List<Integer>> results, List<Integer> out, int[] candidates, int target){
        if(target == 0){
            results.add(new ArrayList<Integer>(out));
        }
        if(target<0){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //  res 中出现重复项
            if(i>start && candidates[i] == candidates[i-1]){
                continue;
            }
            out.add(candidates[i]);
            dfs(i+1, results, out, candidates, target-candidates[i]);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candiates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> resutls = combinationSum2(candiates, target);
        System.out.println(resutls);
    }
}
