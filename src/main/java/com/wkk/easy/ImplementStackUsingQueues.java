package com.wkk.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time: 20-3-24上午11:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ImplementStackUsingQueues {
    /** Initialize your data structure here. */
    private Queue<Integer> queue;
    public ImplementStackUsingQueues() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.add(4);
        queue.offer(5);
        queue.add(7);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

}
