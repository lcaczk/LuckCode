package com.wkk.linkedlist;

import java.util.List;

/**
 * @Time: 20-3-21下午9:41
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode pre = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = GenLinkedList.genList();
        ListNode node = oddEvenList(head);
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);

    }
}
