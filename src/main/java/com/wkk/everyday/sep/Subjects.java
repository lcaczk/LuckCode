package com.wkk.everyday.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongwiki@163.com
 * @since 2020/9/20 9:40 下午
 */
public class Subjects {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(res, out, 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> out, int start, int[] nums) {
        res.add(new ArrayList<>(out));
        for (int i = start; i < nums.length; i++) {
            out.add(nums[i]);
            backtrack(res, out, i + 1, nums);
            out.remove(out.size() - 1);
        }
    }
}
