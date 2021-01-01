package com.common.structure;

/**
 * 双向链表
 * @author kongwiki@163.com
 * @since 2021/1/1
 */
public class DoubleNode {
    public DoubleNode next;
    public DoubleNode pre;
    public Integer val;

    public DoubleNode() {

    }

    public DoubleNode(Integer val) {
        this.val = val;
    }

    public DoubleNode(DoubleNode next, DoubleNode pre, Integer val) {
        this.next = next;
        this.pre = pre;
        this.val = val;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "next=" + next +
                ", pre=" + pre +
                ", val=" + val +
                '}';
    }
}
