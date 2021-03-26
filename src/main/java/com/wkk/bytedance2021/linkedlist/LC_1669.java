package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 思路
        // 因为可能涉及到头节点
        // 建立一个假的节点
        // 通过a， b 找到对应位置，
        // 确定list2 的头 head 尾 tail
        // 0. dummy
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;
        ListNode cur = dummy;
        // 1. 确定list2 的头尾
        ListNode head = list2;
        ListNode tail = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        tail = list2;
        // 2. 删除a b 区间的节点, 并返回前驱节点
        ListNode pre = removeSub(cur, a, b);
        // 3. 重新拼接
        ListNode next = pre.next;
        tail.next = next;
        pre.next = head;
        return dummy.next;

    }

    private ListNode removeSub(ListNode node, int a, int b) {
        int i = 0;
        ListNode cur = node;
        while (i <= a - 1) {
            cur = cur.next;
            i++;
        }
        ListNode pre = cur;
        i = 0;
        cur = node;
        while (i <= b) {
            cur = cur.next;
            i++;
        }
        // 删除区间
        pre.next = cur.next;
        return pre;
    }
}
