package com.wkk.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class LC_946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int idx = 0;
        for (int num : pushed) {
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
            stack.push(num);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        validateStackSequences(pushed, poped);
    }
}
