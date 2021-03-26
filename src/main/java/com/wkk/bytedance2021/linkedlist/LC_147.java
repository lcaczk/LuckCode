package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 147 对链表执行插入排序
 *
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_147 {
    public ListNode insertionSortList(ListNode head) {
        // 思路
        // 遍历节点
        // 同时维护一个新的节点，确保里面节点有序
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode pre = dummy;
        while (head != null) {
            ListNode temp = head.next;
            while (pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }
            // 确定了需要插入的位置
            head.next = pre.next;
            pre.next = head;

            pre = dummy;
            head = temp;
        }
        return dummy.next;
    }
}
