package com.wkk.newcoder.book.linkedlist;

import com.common.structure.ListNode;

/**
 * 链表中的约瑟夫环
 * @author kongwiki@163.com
 * @since 2021/1/1
 */
public class JosephRing {
    public ListNode josephusKill(ListNode head, int m) {
        if (head == null || head.next == head || m < 1){
            return head;
        }
        ListNode tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        int count = 0;
        while (head != tail) {
            count++;
            if (count == m-1) {
                tail.next = head.next;
                count = 0;
            } else {
                tail = tail.next;
            }
            head = tail.next;
        }
        return head;
    }
}
