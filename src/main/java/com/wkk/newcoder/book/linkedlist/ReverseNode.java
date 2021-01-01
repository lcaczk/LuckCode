package com.wkk.newcoder.book.linkedlist;

import com.common.structure.ListNode;

/**
 * 反转单向和双向链表
 * @author kongwiki@163.com
 * @since 2021/1/1
 */
public class ReverseNode {
    public static ListNode reverseListNode(ListNode head) {
       ListNode dummy = new ListNode(-1);
       ListNode pre = dummy;
       while (head != null) {
           // 头插法
           ListNode temp = head.next;
           head.next = pre.next;
           pre.next = head;
           head = temp;
       }
       return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = reverseListNode(node1);
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);
    }
}
