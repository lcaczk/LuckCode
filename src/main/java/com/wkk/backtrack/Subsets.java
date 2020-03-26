package com.wkk.backtrack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-25下午9:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> out = new LinkedList<>();
        backtrack(nums, results, out, 0);
        return results;
    }

    private static void backtrack(int[] nums, List<List<Integer>> results, List<Integer> track, int start) {
        results.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, results, track, i+1);
            track.remove(track.size()-1);
        }



    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);

    }
}
