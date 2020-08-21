package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @Time: 20-2-22下午5:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode head){
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head!=null && head.next!=null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = ConstructNode.testNode();
        ListNode node1 = swapPairs(node);
        System.out.println(node1.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.next.val);
        System.out.println(node1.next.next.next.val);
    }
}
