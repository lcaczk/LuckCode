package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 206 反转链表
 * @author weikunkun
 * @since 2021/3/12
 */
public class LC_206 {
    public ListNode reverseList(ListNode head) {
        // 思路
        // 1. 校验
        // 2. 执行头插法 实现逆序输出
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre.next;
            pre.next = head;
            pre = head;
            head = next;
        }

        return dummy.next;

    }
}
