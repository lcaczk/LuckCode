package com.wkk.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Time: 20-3-26下午1:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode real = dummy;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                real.next = l1;
                l1 = l1.next;
            }else {
                real.next = l2;
                l2 = l2.next;
            }
            real= real.next;
        }
        if (l1 != null){
            real.next = l1;
        }
        if (l2 != null) {
            real.next = l2;
        }

        return dummy.next;
    }
}
