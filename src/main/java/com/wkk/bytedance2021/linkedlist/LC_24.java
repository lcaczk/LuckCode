package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 24 两两交换链表中的节点
 * @author weikunkun
 * @since 2021/3/18
 */
public class LC_24 {
    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 在每一组的尾部进行头插法
        ListNode pre = dummy;
        ListNode tail = dummy;
        while(true) {
            int i = 2;
            while (tail != null && i > 0) {
                tail = tail.next;
                i--;
            }
            // 说明执行完了
            if (Objects.isNull(tail)) {
                break;
            }
            ListNode flag = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            pre = flag;
            tail = pre;
        }

        return dummy.next;
    }
}
