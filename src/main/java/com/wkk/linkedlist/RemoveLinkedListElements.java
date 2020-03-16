package com.wkk.linkedlist;

/**
 * @Time: 20-3-16下午8:11
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }

        }
        return head;
    }

    public static ListNode test(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static ListNode testII(ListNode head) {
        while (head != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        removeElements(node1, 5);

    }
}
