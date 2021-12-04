package com.wkk.monotonicityStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/7/27
 */
public class LC_456 {
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int k = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                k = Math.max(k, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, 6, 7, 8, 9, 10};
        find132pattern(nums);
    }
}
