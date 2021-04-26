package com;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/4/25
 */
public class Test {
    private Deque<Integer> stackPush = new ArrayDeque<>();
    private Deque<Integer> stackPop = new ArrayDeque<>();

    /**
     * 放入
     * @param val
     */
    public void offer(int val) {
        stackPush.push(val);
    }

    /**
     * 弹出
     * 如果没有元素 -1 表示
     * @return
     */
    public int poll() {
        int val = -1;
        if (!stackPop.isEmpty()) {
            val = stackPop.pop();
        }
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
        return val;
    }


}
