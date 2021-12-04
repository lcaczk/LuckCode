package com.wkk.simulation.xp;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * @author weikunkun
 * @since 2021/6/26
 */
public class K个一组翻转链表 {
    public ListNode reverseLinkedList (ListNode head, int k) {
        if (Objects.isNull(head) || k <= 0 ) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = pre;
        while (true) {
            int i = 0;
            // 寻找当前组的tail
            while (Objects.nonNull(tail) && i < k) {
                tail = tail.next;
                i++;
            }
            // tail为空时，说明最后的一组的长度<k
            // 无需进行翻转
            if (Objects.isNull(tail)) {
                break;
            }
            // 组内进行翻转
            ListNode flag = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                // 防止断链
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            // 新的一组
            pre = flag;
            tail = pre;
        }
        // 最后一组也需要翻转
        if (pre.next != null) {
            tail = pre;
            while (tail.next != null) {
                tail = tail.next;
            }
            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
        }
        return dummy.next;
    }
}
