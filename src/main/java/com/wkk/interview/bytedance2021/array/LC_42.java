package com.wkk.interview.bytedance2021.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42 接雨水
 * 思路：
 * 1. 单调栈
 *
 * @author weikunkun
 * @since 2021/3/16
 */
public class LC_42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 用于标记和当前元素相同值
                int curIdx = stack.pop();
                // 用于弹出重复元素
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // 长 * 宽
                    // 长 = i - stackTop - 1
                    // 宽 = Math.min(height[stackTop], height[i]) - height[curIdx];
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
