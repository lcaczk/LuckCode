package com.wkk.linkedlist;

import java.util.LinkedList;

/**
 * @Time: 20-3-26下午5:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode cur;
        while (pre.next != null){
            cur = pre.next;
            while (cur.next!=null && cur.val == pre.val){
                cur = cur.next;
            }
            if(pre.next != cur){
                pre.next = cur;
            }
            else {
                pre = pre.next;
            }
        }
        return head;
    }
}
