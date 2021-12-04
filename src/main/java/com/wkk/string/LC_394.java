package com.wkk.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/6/4
 */
public class LC_394 {
    public static String decodeString(String s) {
        // 存放先前的元素
        Deque<String> stackPre = new ArrayDeque<>();
        // 存放先前的数字
        Deque<Integer> stackNum = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        int N = arr.length;
        int multi = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (isDigit(arr[i])) {
                multi = multi * 10 + arr[i] - '0';
            } else if (arr[i] == '[') {
                // 准备将[]内元素放入 stackChar
                stackNum.push(multi);
                stackPre.add(ans.toString());
                ans = new StringBuilder();
                multi = 0;
            } else if (arr[i] == ']') {
                // 元素已经放完了，重置
                StringBuilder tmp = new StringBuilder(); // 用于累计
                int num = stackNum.pop();
                for (int j = 0; j < num; j++) {
                    tmp.append(ans.toString());
                }
                ans = new StringBuilder(stackPre.removeLast() + tmp);
            } else {
                ans.append(arr[i]);
            }
        }
        return ans.toString();
    }

    private static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    public static void main(String[] args) {
        String s = "3[a10[bc]]";
        System.out.println(decodeString(s));

    }
}
