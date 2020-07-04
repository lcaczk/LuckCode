package com.wkk.everyday.july;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 2020/7/4上午8:06
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LongestValidParentheses {
    // 题目理解出错
    public static int longestValidParentheses(String s) {
        int left = 0;
        int nums = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                continue;
            }
            if (s.charAt(i) == ')') {
                if (left == 0) {
                    continue;
                }else {
                    left--;
                    nums++;
                }
            }

        }
        return nums;
    }
    public static int longestValidParenthesesII(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int nums = 0;
        int start = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                    start = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        nums = Math.max(i-start, nums);
                    }else {
                        nums = Math.max(i-stack.peek(), nums);
                    }

                }
            }
        }
        return nums;

    }

    // 动态规划
    public static int longestValidParenthesesIII(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 2; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = dp[i-2] + 2;
                }else if(s.charAt(i-dp[i-1] - 1) == '('){
                    dp[i] = dp[i-1] + dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }



        public static void main(String[] args) {
        String s = ")()())";
        int i = longestValidParenthesesII(s);
        System.out.println(i);
    }
}
