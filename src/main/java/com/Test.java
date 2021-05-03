package com;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

/**
 * @author weikunkun
 * @since 2021/4/25
 */
public class Test {
    private Deque<Integer> stackPush = new ArrayDeque<>();
    private Deque<Integer> stackPop = new ArrayDeque<>();

    /**
     * 放入
     *
     * @param val
     */
    public void offer(int val) {
        stackPush.push(val);
    }

    /**
     * 弹出
     * 如果没有元素 -1 表示
     *
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

    private void backtrack(int[] arr, List<List<Integer>> res, List<Integer> out, int idx) {
        if (idx == arr.length) {
            return;
        }
    }


    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            if (i % 4 == 0) {
                a.add(Integer.MAX_VALUE);
            } else {
                a.add(i);
            }
        }
        System.out.println(a);
        ListIterator li = a.listIterator();
        while(li.hasNext()){
            Object obj = li.next();

            if(obj.equals(Integer.MAX_VALUE)){
                li.set(-1);
            }
        }
        System.out.println(a);
    }

}
