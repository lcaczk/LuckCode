package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_Offer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (k > 0) {
            first = first.next;
            k--;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
