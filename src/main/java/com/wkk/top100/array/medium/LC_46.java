package com.wkk.top100.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 * @author weikunkun
 * @since 2021/2/16
 */
public class LC_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> store = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(result, out, nums.length, store);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> out, int len, List<Integer> store) {
        if (out.size() == len) {
            result.add(new ArrayList<>(out));
        }
        for(int i = 0; i < len; i++) {
            if (out.contains(store.get(i))) {
                continue;
            }
            out.add(store.get(i));
            backtrack(result, out, len, store);
            out.remove(out.size()-1);
        }
    }
}
