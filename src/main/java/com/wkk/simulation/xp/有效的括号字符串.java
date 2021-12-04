package com.wkk.simulation.xp;

import java.util.Stack;

/**
 * @author weikunkun
 * @since 2021/6/26
 */
public class 有效的括号字符串 {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);//存的是下标
            } else if (s.charAt(i) == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else {
                    if (!starStack.isEmpty()) {
                        starStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (starStack.size() < leftStack.size()) {
            return false;
        } else {
            while (!starStack.isEmpty() && !leftStack.isEmpty()) {
                if (starStack.peek() < leftStack.peek()) {
                    return false;
                }
                starStack.pop();
                leftStack.pop();
            }
            return true;
        }
    }
}
