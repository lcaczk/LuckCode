package com.wkk.newcoder.book.linkedlist;

import com.common.structure.ListNode;

/**
 * 单链表和双链表中删除倒数第k个节点
 * @author kongwiki@163.com
 * @since 2020/12/31
 */
public class RemoveKth {
    /**
     * 单链表
     * @param head
     * @param lastKth
     * @return
     */
    public ListNode removeLastKthNode(ListNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        // 1 -> 2 -> 3 -> 4 -> 5
        // 换一种思路
        ListNode cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        // 1. kth == 0
        if (lastKth == 0) {
            return head.next;
        }
        // 2. kth < 0
        if (lastKth < 0) {
            cur = head;
            while (++lastKth > 0) {
                cur = cur.next;
            }
            // 1 -> 2 -> 3 -> 4 -> 5
            cur.next = cur.next.next;
        }
        return head;
    }
}
