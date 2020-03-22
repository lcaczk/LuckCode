package com.wkk.linkedlist;

/**
 * @Time: 20-3-22下午3:48
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return head;
        }
        int midLength = getLength(head)/2;
        while (midLength > 0){
            head = head.next;
            midLength--;
        }
        return head;
    }
    public int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length ++;
            head = head.next;
        }
        return length;
    }
}
