package com.wkk.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-26上午1:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Permutations {
    private List<List<Integer>> results = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        int k = nums.length;
        List<Integer> out = new LinkedList<>();
        backtrack(nums, out, k);
        return results;

    }

    private void backtrack(int[] nums, List<Integer> track, int k){
        if(track.size() == k){
            results.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track, k);
            track.remove(track.size()-1);
        }
    }
}
