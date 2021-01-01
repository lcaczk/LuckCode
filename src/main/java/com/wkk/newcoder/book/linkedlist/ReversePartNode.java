package com.wkk.newcoder.book.linkedlist;

import com.common.structure.ListNode;

/**
 * @author kongwiki@163.com
 * @since 2021/1/1
 */
public class ReversePartNode {
    /**
     * 反转部分单向链表
     * @param head
     * @param from
     * @param to
     * @return
     */
    public static ListNode reversePart(ListNode head, int from, int to) {
        // 仅做正常逻辑 from to 在链表长度内，且不是头节点
        ListNode fPre = getTargetNode(head, from-1);
        ListNode tTail = getTargetNode(head, to);
        // from = 2 ,  to = 5
        // dummy ->1 -> 2 -> 3 -> 4 -> 5 -> 6
        //        pre                  to
        ListNode cur = fPre.next;
        while (fPre.next != tTail) {
            // 尾插法
            fPre.next = cur.next;
            cur.next = tTail.next;
            tTail.next = cur;
            cur = fPre.next;
        }
        return head;

    }
    public static ListNode getTargetNode(ListNode head, int k) {
        while (--k >0) {
            head = head.next;
        }
        return head;
    }
}
