package com.wkk.bytedance2021.simulation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/4/1
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 思路 使用一个栈 来模拟push的pop（）
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                // 说明需要弹出了
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        ValidateStackSequences sequences = new ValidateStackSequences();
        sequences.validateStackSequences(pushed, popped);
    }
}
