package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 86 分隔链表
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_86 {
    public ListNode partition(ListNode head, int x) {
        // 思路
        // 遍历链表
        // 小于target的使用尾插法构造新的链表A
        // 大于target的使用尾插法构造新的链表B
        // 最后 A 和 B 拼接
        ListNode large = new ListNode(-1);
        ListNode largeHead = large;
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (cur != null) {
            if (cur.val < x) {
                tail.next = cur;
                tail = tail.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        large.next = null;
        tail.next = largeHead;
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        LC_86 lc_86 = new LC_86();
        lc_86.partition(node1,3);

    }
}
