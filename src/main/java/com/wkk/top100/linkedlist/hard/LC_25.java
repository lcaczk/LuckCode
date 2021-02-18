package com.wkk.top100.linkedlist.hard;

import com.common.structure.ListNode;

/**
 * 25 k个一组翻转链表
 * 1. 其实相当于在链表的k个进行翻转然后循环，本质就是链表的k个进行翻转
 * 1.1 找到k组的pre和尾节点tail
 * 1.2 tail前pre后的节点【k组里面的节点】在tail后执行头插，刚好实现了翻转
 * @author weikunkun
 * @since 2021/2/18
 */
public class LC_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }
            // 定位到了当前的尾部
            // 如果为空， 说明已经超过了链表的长度
            if (tail == null) {
                break;
            }
            ListNode flag = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                // 用于防止断链
                ListNode temp = cur.next;
                cur.next = tail.next;
                tail.next = cur;
                pre.next = temp;
            }
            // 下一组的pre, tail
            pre = flag;
            tail = pre;
        }
        return dummy.next;
    }
}
