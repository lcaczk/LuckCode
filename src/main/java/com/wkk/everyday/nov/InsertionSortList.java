package com.wkk.everyday.nov;

import com.common.structure.ListNode;

/**
 * 147. 对链表进行插入排序
 * @author kongwiki@163.com
 * @since 2020/11/20
 */
public class InsertionSortList {
    /**
     * 思路：可以简化为 一个节点插入到一个链表中，保持链表有序
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre;
        while(head != null) {
            ListNode temp = head.next;
            pre = dummy;
            while(pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }
            head.next = pre.next;
            pre.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
