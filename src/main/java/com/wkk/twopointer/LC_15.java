package com.wkk.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author weikunkun
 * @since 2021/5/26
 */
public class LC_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 思路
        // 核心思路：双指针 头尾指针
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int N = nums.length;
        for (int i = 0; i < N - 2; i++) {
            int rst = -nums[i];
            int left = i + 1;
            int right = N - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int cur = nums[left] + nums[right];
                if (cur == rst) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 处理后序重复的元素
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (cur > rst) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
