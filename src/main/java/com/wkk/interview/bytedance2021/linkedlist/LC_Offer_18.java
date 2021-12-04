package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_Offer_18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            }
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}
