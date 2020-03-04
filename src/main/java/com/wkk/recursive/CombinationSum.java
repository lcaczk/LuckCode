package com.wkk.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-3-3上午9:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CombinationSum {
    private static List<List<Integer>> results = new ArrayList<List<Integer>>();
    private static List<Integer> curren = new ArrayList<Integer>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates == null) {
            return results;
        }
        dfs(0, results, curren, candidates, target);
        return results;
    }

    public static void dfs(int start, List<List<Integer>> results, List<Integer> curren, int[] candidates, int target) {
        if(target < 0){
            return;
        }
        if(target == 0){
            results.add(new ArrayList<Integer>(curren));
        }


        for (int i = start; i < candidates.length; i++) {
            curren.add(candidates[i]);
            dfs(i, results, curren, candidates, target-candidates[i]);
            curren.remove(curren.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] c = {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(c, target);
        System.out.println(lists);
    }

}
