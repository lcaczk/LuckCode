package com.wkk.everyday.two1.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 368. 最大整除子集
 *
 * @author weikunkun
 * @since 2021/4/23
 */
public class LC_368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        // 思路
        // dp[i] 以i为结尾的数组中，最大的整除子集
        // dp[i] = Math.max(dp[0 ~ i-1] + 1);
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            Set<Integer> temp = new TreeSet<>();
            while (j < i) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                    }
                }
                j++;
            }
            if (max < dp[i]) {
                res = new ArrayList<>(temp);
                max = dp[i];
            }
        }
        if (res.isEmpty()) {
            res.add(nums[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
        largestDivisibleSubset(array);
    }
}

