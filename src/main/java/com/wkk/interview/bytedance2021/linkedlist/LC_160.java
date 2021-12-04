package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 160 相交链表
 *
 * @author weikunkun
 * @since 2021/3/16
 */
public class LC_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (Objects.isNull(headA) || Objects.isNull(headB)) {
            return headA == null ? headB : headA;
        }
        //思路 构成环 之后 快慢指针
        ListNode tailA = headA;
        while (tailA.next != null) {
            tailA = tailA.next;
        }
        tailA.next = headA;
        ListNode fast = headB;
        ListNode slow = headB;
        ListNode result = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                result = headB;
                while (result != slow) {
                    result = result.next;
                    slow = slow.next;
                }
                break;
            }
        }
        tailA.next = null;
        return result;
    }
}
