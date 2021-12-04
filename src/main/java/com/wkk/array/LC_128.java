package com.wkk.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/6/21
 */
public class LC_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            } else {
                int distance = 1;
                while (set.contains(nums[i] + distance)) {
                    distance++;
                }
                max = Math.max(max, distance);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
