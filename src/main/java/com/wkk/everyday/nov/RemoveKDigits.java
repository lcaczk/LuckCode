package com.wkk.everyday.nov;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. 移掉K位数字
 * @author kongwiki@163.com
 * @since 2020/11/15
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return num;
        }
        int len = num.length();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        while (k > 0) {
            deque.pollLast();
            k--;
        }
        // 返回输出结果
        StringBuilder sb = new StringBuilder();
        Boolean judgeZero = true;
        while (!deque.isEmpty()) {
            Character ch = deque.pollFirst();
            if (judgeZero && ch == '0') {
                continue;
            }
            judgeZero = false;
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();

    }
}
