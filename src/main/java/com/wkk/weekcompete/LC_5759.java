package com.wkk.weekcompete;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有子集的异或总和再求和
 *
 * @author weikunkun
 * @since 2021/5/16
 */
public class LC_5759 {

    public static int subsetXORSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        backtrack(nums, list, out, 0);
        for (List<Integer> integers : list) {
            int innerAns = 0;
            for (Integer integer : integers) {
                innerAns ^= integer;
            }
            ans += innerAns;
        }
        System.out.println(list);
        return ans;
    }

    private static void backtrack(int[] nums, List<List<Integer>> results, List<Integer> track, int start) {
        results.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, results, track, i + 1);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int i = subsetXORSum(nums);
        System.out.println(i);
    }

}
