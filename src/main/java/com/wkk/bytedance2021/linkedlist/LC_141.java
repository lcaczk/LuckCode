package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 141 环形链表
 * @author weikunkun
 * @since 2021/3/17
 */
public class LC_141 {
    public boolean hasCycle(ListNode head) {
        // 思路 快慢指针
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
