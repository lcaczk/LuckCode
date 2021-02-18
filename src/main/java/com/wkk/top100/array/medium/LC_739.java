package com.wkk.top100.array.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739 每日温度
 * 1. 暴力破解
 * 2. 单调栈
 *  单调栈的使用还有其他题目：
 *  2.1 42 接雨水
 *  2.2 84 柱状图中最大的矩形
 * @author weikunkun
 * @since 2021/2/18
 */
public class LC_739 {
    /**
     * O(n^2) 时间复杂度
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if (null == T || T.length == 0) {
            return null;
        }
        // O(N^2)
        for (int i = 0; i < T.length - 1; i++) {
            int cur = T[i];
            int maxIndex = i;
            for (int j = i + 1; j < T.length; j++) {
                if (cur < T[j]) {
                    maxIndex = j;
                    break;
                }
            }
            if (maxIndex == i) {
                T[i] = 0;
            } else {
                T[i] = maxIndex - i;
            }
        }
        return T;
    }

    /**
     * 单调栈
     * 维护一个单调减的栈（具体维护单调增/减的栈，根据题意来）
     * @param T
     * @return
     */
    public int[] dailyTemperaturesII(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (null == T || T.length == 0) {
            return null;
        }
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && T[stack.peek()] < temperature ) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        LC_739 lc_739 = new LC_739();
        int[] array = {73, 74, 75, 71, 69, 72, 76, 73};
        lc_739.dailyTemperatures(array);
    }
}
