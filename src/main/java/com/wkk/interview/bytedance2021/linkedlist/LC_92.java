package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 92 翻转链表II
 * 思路
 * 等于k个一组进行翻转，不过仅仅有一组
 * @author weikunkun
 * @since 2021/3/18
 */
public class LC_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left > right || Objects.isNull(head)) {
            return head;
        }
        // 找到 tail pre
        // pre.next != tail
        //  内部 在tail执行尾插法
        ListNode dummy = new ListNode (-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (left > 1) {
            pre = pre.next;
            left--;
        }
        while (right > 0) {
            tail = tail.next;
            right--;
        }
        while (pre.next != tail) {
            ListNode cur = pre.next;
            pre.next = cur.next;
            cur.next = tail.next;
            tail.next = cur;
        }
        return dummy.next;
    }
}
