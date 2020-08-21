package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @Time: 20-3-17上午11:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode preEndNode = getPreEndNode(head);
        ListNode endNode = preEndNode.next;
        endNode.next = head.next;
        head.next = endNode;
        preEndNode.next = null;
    }

    public static ListNode getPreEndNode(ListNode head){
        int len = 0;
        ListNode p = head;
        while(p != null){
            len ++;
            p = p.next;
        }
        p = head;
        while (len-2 >0){
            p = p.next;
            len--;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode node = GenLinkedList.genList();
        reorderList(node);
        System.out.println(node.next.val);
    }

}
