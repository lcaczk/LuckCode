package com.wkk.stack;

import java.util.Stack;

/**
 * @Time: 20-3-16下午1:10
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MinStack_155 {
    private Stack<Integer> stack = new Stack<>();
    public MinStack_155(){

    }

    public void push(int x){
        stack.push(x);
    }

    public void pop(){
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        int min = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if(integer < min){
                min = integer;
            }
        }
        return min;
    }
}
