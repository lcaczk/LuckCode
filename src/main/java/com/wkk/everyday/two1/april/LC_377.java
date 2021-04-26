package com.wkk.everyday.two1.april;

import java.util.HashMap;
import java.util.Map;

/**
 * 排列组合IV
 * @author weikunkun
 * @since 2021/4/24
 */
public class LC_377 {
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 记忆递归
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        // 回溯
        // 排列问题，不同顺序不同结果
        // 所以不需要起始位置
        // 并且元素不重复
        return backtrack(nums, target);
    }

    private int backtrack(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                res += backtrack(nums, target - nums[i]);
            }
        }

        map.put(target, res);
        return res;
    }

    public static void main(String[] args) throws InterruptedException {
    }
}
