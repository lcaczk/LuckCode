package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-3-26上午9:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SubsetsII {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null){
            return results;
        }
        Arrays.sort(nums);
        List<Integer> out = new ArrayList<>();
        backtrack(nums, out, 0);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> out, int start) {
        results.add(new ArrayList<>(out));
        for (int i = start; i < nums.length; i++) {
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            out.add(nums[i]);
            backtrack(nums, out, i+1);
            out.remove(out.size()-1);
        }
    }
}
