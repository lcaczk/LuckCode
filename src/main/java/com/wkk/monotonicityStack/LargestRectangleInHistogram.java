package com.wkk.monotonicityStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 2020/6/15上午9:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LargestRectangleInHistogram {
    // 枚举宽 双重循环
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for (int left = 0; left < n; left++) {
            int min = heights[left];
            for (int right = left; right < n; right++) {
                min = Math.min(min, heights[right]);
                ans = Math.max(ans, (right - left + 1) * min);
            }
        }
        return ans;
    }

    // 枚举高
    public int largestRectangleAreaII(int[] heights) {
        int len = heights.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int currentHeight = heights[i];
            int left = i;
            int right = i;
            while (left - 1 >= 0 && currentHeight < heights[left - 1]) {
                left--;
            }
            while (right + 1 <= len && currentHeight < heights[right + 1]) {
                right++;
            }
            ans = Math.max(ans, (right - left + 1) * currentHeight);
        }
        return ans;
    }

    public int largestRectangleAreaIII(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> mono_stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] s = {2, 1, 2};
        LargestRectangleInHistogram rectangle = new LargestRectangleInHistogram();
        int i = rectangle.largestRectangleAreaII(s);
        System.out.println(i);
    }
}

