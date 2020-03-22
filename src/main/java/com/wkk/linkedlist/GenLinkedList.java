package com.wkk.linkedlist;

/**
 * @Time: 20-3-17上午8:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class GenLinkedList {
    public static ListNode genList(){
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        return node0;
    }
}
