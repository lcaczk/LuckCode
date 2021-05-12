package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * 1474. 删除链表 M 个节点之后的 N 个节点
 * @author weikunkun
 * @since 2021/5/8
 */
public class LC_1474 {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 思路 while循环里面删除
        // 先找到第m个节点
        // 再删除n个节点，同时需要得到其后续节点
        ListNode pre = dummy;
        ListNode cur = dummy;
        while (pre != null) {
            int saveCount = m;
            int deleteCount = n;
            while (saveCount > 0 && pre != null) {
                pre = pre.next;
                saveCount--;
            }
            if (pre == null) {
                break;
            }
            cur = pre.next;
            while (deleteCount > 0 && cur != null) {
                cur = cur.next;
                deleteCount--;
            }
            pre.next = cur;
        }
        return dummy.next;
    }
}
