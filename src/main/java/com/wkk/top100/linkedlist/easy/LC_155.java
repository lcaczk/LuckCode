package com.wkk.top100.linkedlist.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_155 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public LC_155() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
