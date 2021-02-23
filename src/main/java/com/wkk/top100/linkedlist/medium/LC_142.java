package com.wkk.top100.linkedlist.medium;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 142 环形链表II
 * 思路： 快慢指针
 * @author weikunkun
 * @since 2021/2/22
 */
public class LC_142 {
    public ListNode detectCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = head;
                while (temp != slow) {
                    slow = slow.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
        return null;
    }
}
