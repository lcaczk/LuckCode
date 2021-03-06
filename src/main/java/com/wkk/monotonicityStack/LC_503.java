package com.wkk.monotonicityStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 503 下一个更大元素II
 * @author weikunkun
 * @since 2021/3/6
 */
public class LC_503 {
    /**
     * 单调栈 + 循环数组
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        if (null == nums || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                int idx = stack.pop();
                res[idx] = nums[i % len];
            }
            stack.push(i);
        }
        return res;
    }
}
