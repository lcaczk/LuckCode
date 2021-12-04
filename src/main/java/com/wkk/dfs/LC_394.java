package com.wkk.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author weikunkun
 * @since 2021/6/4
 */
public class LC_394 {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(2);
    }

    private static boolean isDigits(char ch) {
        return Character.isDigit(ch);
    }
}
