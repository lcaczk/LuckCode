package com.wkk.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1190. 反转每对括号间的子串
 * 使用栈
 * 然后按照题意模拟进行
 * 然后按照区间进行反转 （双指针）
 * @author weikunkun
 * @since 2021/5/26
 */
public class LC_1190 {
    private char LEFT = '(';
    private char RIGHT = ')';

    public String reverseParentheses(String s) {
        // 模拟
        // stack
        Deque<Integer> stack = new ArrayDeque<>();
        int N = s.length();
        char[] array = s.toCharArray();
        // 思路
        // 使用栈存储，之后哦碰到一个完整的括号，就翻转里面的内容，然后continue
        // 涉及问题：字符串翻转函数
        for (int i = 0; i < N; i++) {
            if (array[i] == LEFT) {
                stack.push(i);
            } else if (array[i] == RIGHT) {
                // 获取当前交换子区间
                swap(array, stack.pop() + 1, i - 1);
            }
        }
        return toString(array);
    }

    private void swap(char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != LEFT && array[right] != RIGHT) {
                char tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
                left++;
                right--;
            } else if (array[left] == LEFT) {
                left++;
            } else if (array[right] == RIGHT) {
                right--;
            }
        }
    }

    private String toString(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (char ch : array) {
            if (ch != LEFT && ch != RIGHT) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
