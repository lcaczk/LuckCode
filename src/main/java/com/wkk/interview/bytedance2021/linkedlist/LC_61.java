package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 61. 旋转链表
 *
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_61 {
    public ListNode rotateRight(ListNode head, int k) {
        // 思路
        // 快慢指针
        // 1. 类似找到倒数第k个节点 kNode (从dummy开始方便)
        // 2. first 已经指向最后一个 （根据题意，fist定位到最后一个，方便fist指向第一个正常节点）
        // 3. second 指向 kNode 前驱
        // 4. 头称为 kNode 然后断开
        if (head == null) {
            return head;
        }
        int len = getListNodeLen(head);
        k = k % len;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (k > 0) {
            first = first.next;
            k--;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        // first 构成环
        first.next = head;
        head = second.next;
        second.next = null;
        return head;
    }

    private int getListNodeLen(ListNode kNode) {
        int count = 0;
        while (kNode != null) {
            kNode = kNode.next;
            count++;
        }
        return count;
    }
}
