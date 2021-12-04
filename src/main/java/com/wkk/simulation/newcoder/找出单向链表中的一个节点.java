package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/7
 */
public class 找出单向链表中的一个节点 {
    public static void main(String[] args) {
        ListNode head = genListNode();
        ListNode fast = head;
        ListNode slow = head;
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.value);
    }

    private static ListNode genListNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        return node1;
    }

    private static class ListNode {
        public int value;
        public ListNode next;

        public ListNode() {

        }

        public ListNode(int value) {
            this.value = value;
        }
    }
}
