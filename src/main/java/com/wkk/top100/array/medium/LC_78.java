package com.wkk.top100.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 78 子集
 * 回溯基础
 * @author weikunkun
 * @since 2021/2/16
 */
public class LC_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =  new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        List<Integer> store = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (nums.length == 0) {
            return result;
        }
        int len = nums.length;
        backtrack(result, out, 0, len, store);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> out, int start, int len, List<Integer> nums) {
        if (start >= len) {
            return;
        }
        result.add(new ArrayList<>(out));
        for(int i = start; i < len; i++) {
            out.add(nums.get(i));
            backtrack(result, out, i+1, len, nums);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {
        LC_78 lc_78 = new LC_78();
        int [] nums = {1,2,3};
        lc_78.subsets(nums);
    }
}
