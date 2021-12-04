package com.wkk.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/10/21
 */
public class LC_66 {
    public static int[] plusOne(int[] digits) {
        // 思路
        // 模拟加法
        // 引入栈
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(digits).forEach(ele->stack.push(ele));
        int carry = 0;
        int base = 1;
        Deque<Integer> resStack = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            int cur = pop + base + carry;
            resStack.push(cur % 10);
            carry = cur / 10;
            base = 0;
        }
        if (carry != 0) {
            resStack.push(carry);
        }
        return resStack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] ints = plusOne(digits);
        Arrays.stream(ints).forEach(i->System.out.print(i + " "));
    }
}
