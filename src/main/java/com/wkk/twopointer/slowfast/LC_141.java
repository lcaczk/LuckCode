package com.wkk.twopointer.slowfast;

import com.common.structure.ListNode;

/**
 * @author weikunkun
 * @since 2021/5/27
 */
public class LC_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
