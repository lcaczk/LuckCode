package com.wkk.everyday.two1.feb;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 896 单调数列
 * @author weikunkun
 * @since 2021/2/28
 */
public class LC_896 {
    public boolean isMonotonic(int[] A) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : A) {
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            stack.push(num);
        }
        return stack.isEmpty() || stack.size() == A.length;
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,3};
        int[] ano = {6,5,4,4};
        LC_896 lc_896 = new LC_896();
        lc_896.isMonotonic(ano);
    }
}
