package com.wkk.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-3-3下午8:13
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CombinationSumIV {
    private static List<List<Integer>> results = new ArrayList<List<Integer>>();
    private static List<Integer> out = new ArrayList<Integer>();
    public static int combinationSum4(int[] nums, int target) {
        if(nums.length == 0){
            return results.size();
        }
        Arrays.sort(nums);
        dfs(0, results, out, nums, target);
        return results.size();
    }

    private static void dfs(int start, List<List<Integer>> results, List<Integer> out, int[] nums ,int target) {
        if(target == 0){
            results.add(new ArrayList<Integer>(out));
            return;
        }
        if(target < 0){
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            out.add(nums[i]);
            dfs(start, results, out, nums, target-nums[i]);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1};
        int target = 32;
        int i = combinationSum4(nums, target);
        System.out.println(i);
    }
}
