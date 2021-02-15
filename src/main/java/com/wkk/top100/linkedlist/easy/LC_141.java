package com.wkk.top100.linkedlist.easy;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 141 环形链表
 * 快慢指针
 * @author weikunkun
 * @since 2021/2/15
 */
public class LC_141 {
    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        return cycle;
    }
}
