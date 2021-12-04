package com.wkk.interview.bytedance2021.design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232 栈实现队列
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_232 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public LC_232() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
