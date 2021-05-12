package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @author weikunkun
 * @since 2021/5/8
 */
public class LC_0204 {
    public ListNode partition(ListNode head, int x) {
        // 两个链表
        // 之后拼接
        if  (head == null) {
            return head;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smalTail = smallHead;
        ListNode largeHead = new ListNode(-1);
        ListNode largeTail = largeHead;
        // 注意构成环的问题
        while (head != null) {
            if (head.val < x) {
                smalTail.next = head;
                smalTail = smalTail.next;
            } else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }
        // 断链处理
        largeTail.next = null;
        smalTail.next = largeHead.next;
        return smallHead.next;
    }
}
