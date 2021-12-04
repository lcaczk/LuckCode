package com.wkk.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 计算器 II
 *
 * @author weikunkun
 * @since 2021/8/2
 */
public class LC_227 {
    public static int calculate(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        char preSig = '+';
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(chs[i])) {
                num = num * 10 + chs[i] - '0';
            }
            if ((!Character.isDigit(chs[i]) && chs[i] != ' ') || i == n - 1) {
                switch (preSig) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSig = chs[i];
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "3+2*2";
        calculate(str);
    }
}
