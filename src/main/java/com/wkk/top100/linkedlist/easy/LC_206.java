package com.wkk.top100.linkedlist.easy;

import com.common.structure.ListNode;

/**
 * 206 反转链表
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_206 {
    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
