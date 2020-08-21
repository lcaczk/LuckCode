package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @Time: 20-3-17上午11:52
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre;
        while (head != null) {
            ListNode t = head.next;
            pre = dummy;
            while (pre.next != null && pre.next.val < head.val){
                pre = pre.next;
            }
            head.next = pre.next;
            pre.next = head;
            head = t;

        }
        return dummy.next;
    }

    public static ListNode insertionSortListII(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }
}
