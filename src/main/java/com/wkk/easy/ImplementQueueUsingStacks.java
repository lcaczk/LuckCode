package com.wkk.easy;

import java.util.Stack;

/**
 * @Time: 20-3-24下午3:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> stack;
    public ImplementQueueUsingStacks(){
        this.stack = new Stack<>();
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        stack.push(x);
        while (!stack.isEmpty()){
            temp.push(stack.pop());
        }
        stack = temp;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
