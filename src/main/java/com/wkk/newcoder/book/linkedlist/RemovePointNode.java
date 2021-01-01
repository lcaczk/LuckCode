package com.wkk.newcoder.book.linkedlist;

import com.common.structure.ListNode;

/**
 * 删除链表的中间节点和a/b处的节点
 * @author kongwiki@163.com
 * @since 2021/1/1
 */
public class RemovePointNode {
    public ListNode removeMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next.next;
        while (pre.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
