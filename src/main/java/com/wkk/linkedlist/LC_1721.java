package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @author weikunkun
 * @since 2021/5/7
 */
public class LC_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        // 交换
        // 直接覆盖值 先获取第k和倒数k的节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = getListNodeLen(head);
        ListNode first = getListNode(head, k);
        ListNode last = getListNode(head, len - k + 1);
        int tmep = first.val;
        first.val = last.val;
        last.val = tmep;
        return dummy.next;
    }

    private int getListNodeLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    private ListNode getListNode(ListNode head, int k) {
        while (k > 0 && head.next != null) {
            head = head.next;
            k--;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
