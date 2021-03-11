package com.wkk.everyday.two1.may;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1047 删除字符串中的所有相邻重复项
 * @author weikunkun
 * @since 2021/3/9
 */
public class LC_1047 {
    /**
     * 思路：根据理解，发现可以使用栈来实现
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] array = s.toCharArray();
        for (char ch : array) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.toString());
    }
}
