package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @Time: 20-3-17上午9:21
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = null;
        ListNode pre = dummy;
        while (pre.next != null) {
            cur = pre.next;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if(cur != pre.next){
                pre.next = cur.next;

            }
            else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
