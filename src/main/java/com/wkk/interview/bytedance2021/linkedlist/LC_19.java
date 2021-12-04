package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 19 删除链表的倒数第 N 个结点
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 思路 快慢指针
        int i = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fist = dummy;
        ListNode second = dummy;
        while (i < n) {
            fist = fist.next;
            i++;
        }
        while(fist.next != null) {
            fist = fist.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
