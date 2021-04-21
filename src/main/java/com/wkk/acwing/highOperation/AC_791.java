package com.wkk.acwing.highOperation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/4/21
 */
public class AC_791 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String num1 = String.valueOf(sc.nextLine());
            String num2 = String.valueOf(sc.nextLine());
            int flag = 0;
            char[] ch1 = num1.toCharArray();
            char[] ch2 = num2.toCharArray();
            Deque<Character> stack1 = genStack(ch1);
            Deque<Character> stack2 = genStack(ch2);
            StringBuilder sb = new StringBuilder();
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                int a = stack1.isEmpty() ? 0 : stack1.pop() - '0';
                int b = stack2.isEmpty() ? 0 : stack2.pop() - '0';
                int sum = a + b + flag;
                sb.append(sum % 10);
                flag = sum / 10;
            }
            // 收尾
            if (flag != 0) {
                sb.append(flag);
            }
            System.out.println(sb.reverse().toString());
        }
    }

    private static Deque<Character> genStack(char[] array) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : array) {
            stack.push(ch);
        }
        return stack;
    }
}
