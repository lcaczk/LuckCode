package com.wkk.everyday.june;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 2020/6/30下午7:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ImplementQueue {
    private Deque<Integer> a, b;
    public ImplementQueue(){
        a = new ArrayDeque<>();
        b = new ArrayDeque<>();
    }

    public void appendTail(int value){
        a.push(value);
    }

    public int deleteHead(){
        if(!b.isEmpty()){
            return b.pop();
        }
        if(a.isEmpty()){
           return -1;
        }
        while (!a.isEmpty()){
            b.push(a.poll());
        }
        return b.pop();
    }
}
