package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 从链表中删去总和值为零的连续节点
 * 思路和删光所有重复元素类似
 * @author weikunkun
 * @since 2021/4/16
 */
public class LC_1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur;
        boolean zero = false;
        while (pre.next != null) {
            cur = pre.next;
            int sum = cur.val;
            while (cur != null) {
                if (sum == 0) {
                    zero = true;
                    break;
                }
                cur = cur.next;
                if (cur != null) {
                    sum += cur.val;
                }
            }
            if (zero) {
                if (cur != null) {
                    pre.next = cur.next;
                } else {
                    pre.next = null;
                }
                zero = false;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(-3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LC_1171 lc_xx = new LC_1171();
        lc_xx.removeZeroSumSublists(node1);
    }
}
