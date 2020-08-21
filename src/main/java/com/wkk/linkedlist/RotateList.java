package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @Time: 20-3-17上午8:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RotateList {
    // 快慢指针
    public static ListNode roateRightII(ListNode head, int k){
        if(head == null){
            return null;
        }
        int length = getLength(head);
        k %= length;
        ListNode endNode = getEndNode(head);
        ListNode fast = head, slow = head;
        while (k > 0){
            fast = fast.next;
            k--;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 构成环
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    // 链表变环
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int length = getLength(head);
        k %= length;
        ListNode endNode = getEndNode(head);
        endNode.next = head;
        for (int i = 1; i <= k; i++) {
            head = endNode;
            endNode = getCircleEnd(head, length);

        }
        endNode.next = null;
        return head;

    }
    public static ListNode getCircleEnd(ListNode head, int length){
        ListNode p = head;
        for (int i = 0; i < length - 1; i++) {
            p  = p.next;
        }
        return p;

    }
    public static ListNode getEndNode(ListNode head){
        ListNode p = head;
        while (p.next != null){
            p = p.next;
        }
        return p;
    }
    public static int getLength(ListNode head){
        if(head == null){
            return 0;
        }
        int length = 0;
        while (head != null){
            length ++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode node = GenLinkedList.genList();
        ListNode node1 = roateRightII(node, 2);
        System.out.println(node1.val);
    }
}
