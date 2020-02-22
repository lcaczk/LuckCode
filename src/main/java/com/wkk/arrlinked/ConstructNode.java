package com.wkk.arrlinked;

/**
 * @Time: 20-2-22下午5:24
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConstructNode {
    public static ListNode node1 = new ListNode(1);
    public static ListNode node2 = new ListNode(2);
    public static ListNode node3 = new ListNode(3);
    public static ListNode node4 = new ListNode(4);
    public static ListNode node5 = new ListNode(5);

    public static ListNode testNode() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        return node1;

    }
}
