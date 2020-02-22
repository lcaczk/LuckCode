package com.wkk.arrlinked;

/**
 * @Time: 20-2-22下午4:10
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */


public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode current = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = current;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode node = reverseList(node1);
        System.out.println(node.val);

    }
}
