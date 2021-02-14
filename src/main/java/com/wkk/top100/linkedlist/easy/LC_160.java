package com.wkk.top100.linkedlist.easy;

import com.common.structure.ListNode;

/**
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tailA = headA;
        while(tailA.next != null) {
            tailA = tailA.next;
        }
        // 构成环
        tailA.next = headA;
        ListNode fast = headB;
        ListNode slow = headB;
        ListNode slowII = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slowII = headB;
                while(slowII != slow) {
                    slowII = slowII.next;
                    slow = slow.next;
                }
                break;
            }

        }
        tailA.next = null;
        return slowII;
    }
}
