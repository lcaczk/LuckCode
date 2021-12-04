package com.common.structure;

import java.util.List;

/**
 * @author weikunkun
 * @since 2021/2/23
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node prev;
    public Node next;
    public Node random;
    public Node child;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }

    public Node(int val, Node left, Node right, Node next, Node random, List<Node> children) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
        this.random = random;
        this.children = children;
    }
}
