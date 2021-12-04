package com.wkk.interview.bytedance2021.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return result;
        }
        backtrack(result, out, candidates, 0, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> out, int[] candidates,  int currentSum, int target, int start) {
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

    public static void main(String[] args) {
        int[] costs = {1,6,3,1,2,5};
        List<Integer> collect = Arrays.stream(costs).boxed().collect(Collectors.toList());
        int coins = 20;
        System.out.println(combinationSum(costs, coins));
    }
}
