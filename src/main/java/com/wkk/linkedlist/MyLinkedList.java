package com.wkk.linkedlist;

import java.util.LinkedList;

/**
 * 707 设计链表
 * 模拟LinedList
 * @author weikunkun
 * @since 2021/5/7
 */
public class MyLinkedList {
    private int size = 0;
    private Node first;
    private Node last;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        return node(index).val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node f = first;
        Node node = new Node(null, val, f);
        first = node;
        if (f == null) {
            last = node;
        } else {
            f.pre = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node l = last;
        Node newNode = new Node(l, val, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else {
            linkBefore(val, node(index));
        }
    }

    private Node node(int index) {
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.pre;
            return x;
        }
    }

    /**
     * 在succ前插入元素
     */
    private void linkBefore(int val, Node succ) {
        Node pre = succ.pre;
        Node newNode = new Node(pre, val, succ);
        // 开始执行断链
        succ.pre = newNode;
        if (pre == null) {
            first = newNode;
        } else {
            pre.next = newNode;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // 先获取元素
        Node l = last;
        if (l == null) {
            return;
        }
        int i = unlinkLast(node(index));
//        System.out.println(i);
    }

    private int unlinkLast(Node x) {
        Node pre = x.pre;
        Node next = x.next;
        int val = x.val;
        x.pre = null;
        x.next = null;
        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
        }
        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
        }
        size--;
        return val;
    }

    private class Node {
        public int val;
        public Node next;
        public Node pre;

        public Node(Node pre, int val, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node() {

        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(2);
        linkedList.remove(0);

    }
}
