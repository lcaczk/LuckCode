package com.wkk.top.twopointer;

import com.common.structure.ListNode;

/**
 * @author kongwiki@163.com
 * @since 2020/8/8下午12:08
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast, slow;
        fast = head;
        slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
