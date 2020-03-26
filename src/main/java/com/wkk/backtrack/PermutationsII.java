package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-3-26上午1:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PermutationsII {
    private static List<List<Integer>> results = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> out = new ArrayList<>();
        backtrack(nums, out, new boolean[nums.length]);
        return results;
    }

    private static void backtrack(int[] nums, List<Integer> out, boolean[] visited) {
        if (out.size() == nums.length) {
            results.add(new ArrayList<>(out));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //重复元素只按顺序选择，若当前元素未被选择且前一元素与当前元素值相等也未被选择则跳过，
            // 这一可能情况与先选小序号后选大序号的相同元素相同

            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i-1]) {
                continue;
            }
            out.add(nums[i]);
            visited[i] = true;
            backtrack(nums, out, visited);
            out.remove(out.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(a);
        System.out.println(lists);
        boolean[] b = {false, false, false};
    }
}
