package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 328 奇偶链表
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_328 {
    // 思路
    // 遍历整个链表，然后按照位置进行区分，构造两个子链表
    // 保证有序性 使用尾插法构建链表
    // 最后合并连个链表
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenListII(ListNode head) {
        //思路
        // 按照位置分奇偶，然后使用尾插法尾插 构建奇偶链表
        if (null == head) {
            return head;
        }
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode evenHead = even;
        ListNode oddHead = odd;
        int i = 0;
        while (head != null) {
            i++;
            if (i % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
        }
        // 断开， 防止构成环
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LC_328 lc_328 = new LC_328();
        lc_328.oddEvenList(node1);
    }
}
