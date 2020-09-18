package com.wkk.everyday.sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：全排列II
 * <p>
 * 描述：
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 题解：回溯（做了两天树的题目，又回到回溯了）
 * @author kongwiki@163.com
 * @since 2020/9/18 7:18 下午
 */
public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> out = new ArrayList<>();
        backtrack(res, out, nums, nums.length, visited);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> out, int[] nums, int k, boolean[] visited) {
        if (out.size() == k) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            对原数组排序，保证相同的数字都相邻，
//            然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
            // 具体详见liweiwei的题解
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            out.add(nums[i]);
            backtrack(res, out, nums, k, visited);
            out.remove(out.size() - 1);
            visited[i] = false;
        }
    }




}
