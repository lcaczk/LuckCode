package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 82 删除排序链表中重复元素（不保留）
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre= dummy;
        ListNode cur;
        while (pre.next != null) {
            cur = pre.next;
            while(cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (pre.next != cur) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

}
