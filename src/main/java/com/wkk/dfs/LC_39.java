package com.wkk.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 组合总数
 * @author weikunkun
 * @since 2021/6/2
 */
public class LC_39 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayDeque<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int idx, Deque<Integer> tmp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = idx; i < candidates.length; i++) {
            tmp.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, tmp);
            tmp.removeLast();
        }
    }
}

