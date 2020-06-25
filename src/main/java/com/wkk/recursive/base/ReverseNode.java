package com.wkk.recursive.base;

import com.wkk.tree.Node;
import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

/**
 * @Time: 2020/6/25下午3:04
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReverseNode {
    public static Node reverseList(Node node){
        // 如果只有一个节点, 或者链表为空
        if(node == null || node.next == null ){
            return node;
        }
        Node temp = reverseList(node.next);
        Node t1 = node.next;
        t1.next = node;
        node.next = null;
        return temp;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        Node node4 = reverseList(node);
        System.out.println(node4.val);
        System.out.println(node4.next.val);
    }
}
