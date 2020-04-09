package com.wkk.string;

import java.util.Stack;

/**
 * @Time: 20-4-9下午1:13
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                    start = i;
                }else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        res = Math.max(i - start, res);
                    }else {
                        res = Math.max(i-stack.peek(), res);
                    }
                }
            }
        }
        return res;
    }
}
