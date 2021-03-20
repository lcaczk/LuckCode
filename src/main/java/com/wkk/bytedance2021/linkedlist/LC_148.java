package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 148 排序链表
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_148 {
    public ListNode sortList(ListNode head) {
        // 1. 转化为数组 排序
        // 插入排序
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(head != null) {
            while(pre.next != null && pre.next.val <= head.val) {
                pre = pre.next;
            }
            ListNode temp = head.next;
            // 插入对应的位置
            head.next = pre.next;
            pre.next = head;
            pre = dummy;
            head = temp;
        }
        return dummy.next;
    }
}
