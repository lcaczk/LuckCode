package com.wkk.newcoder.book.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 2020/6/30下午7:41
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ImplementMinStack {
    private Deque<Integer> stackData;
    private Deque<Integer> stackMin;

    public ImplementMinStack() {
        stackData = new ArrayDeque<>();
        stackMin = new ArrayDeque<>();
    }

    public int getMin() {
        return stackMin.peek();
    }

    public void push(int value) {
        stackData.push(value);
         if (!stackMin.isEmpty() ||  stackMin.peek() >= value) {
            stackMin.push(value);
        }
    }

    public void pop() {
        //处理
        if (stackData.pop().equals(stackMin.peek())) {
            stackMin.pop();
        }
    }
}
