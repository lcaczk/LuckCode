package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @Time: 20-3-18下午8:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = getPreNode(dummy, n);
        preNode.next = preNode.next.next;
        return head;
    }

    public static ListNode getPreNode(ListNode head, int n){
        int count = 0;
        ListNode p = head;
        while (p != null){
            count ++;
            p = p.next;
        }
        p = head;
        while ( count-n-1 > 0){
            p = p.next;
            count --;
        }

        return p;

    }

    public static void main(String[] args) {
        ListNode node = GenLinkedList.genList();
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode preNode = getPreNode(dummy, 2);
        System.out.println(preNode.val);
//        ListNode node1 = removeNthFromEnd(node, 2);
//        System.out.println(node1.val);
//        System.out.println(node1.next.val);
//        System.out.println(node1.next.next.val);
//        System.out.println(node1.next.next.next.val);
//

    }
}
