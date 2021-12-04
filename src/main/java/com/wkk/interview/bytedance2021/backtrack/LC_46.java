package com.wkk.interview.bytedance2021.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/3/18
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
