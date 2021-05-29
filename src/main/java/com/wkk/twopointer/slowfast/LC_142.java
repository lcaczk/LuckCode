package com.wkk.twopointer.slowfast;

import com.common.structure.ListNode;

/**
 * @author weikunkun
 * @since 2021/5/27
 */
public class LC_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode slowII = head;
                while (slow != slowII) {
                    slowII = slowII.next;
                    slow = slow.next;
                }
                return slowII;
            }
        }
        return null;
    }
}
