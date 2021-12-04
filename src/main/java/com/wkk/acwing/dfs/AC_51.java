package com.wkk.acwing.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/5
 */
public class AC_51 {
    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, new ArrayDeque<>());
        return res;

    }

    private static void dfs(int[] nums, Deque<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.addLast(nums[i]);
            dfs(nums, tmp);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permutation(arr));
    }
}
