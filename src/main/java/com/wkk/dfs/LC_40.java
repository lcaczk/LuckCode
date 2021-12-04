package com.wkk.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 组合总数II
 * @author weikunkun
 * @since 2021/6/2
 */
public class LC_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return result;
        }
        // 有重复的元素，需要剔除
        Arrays.sort(candidates);
        backtrack(result, new ArrayDeque<>(), candidates, target, 0, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, Deque<Integer> out, int[] candidates, int target, int currentSum, int index) {
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
            out.addLast(candidates[i]);
            backtrack(result, out, candidates, target, currentSum + candidates[i], i+1);
            out.removeLast();
        }
    }
}
