package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 876 中间节点
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_876 {
    public ListNode middleNode(ListNode head) {
        // 思路 快慢指针
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
