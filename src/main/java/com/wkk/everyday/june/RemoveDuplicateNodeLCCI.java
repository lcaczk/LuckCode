package com.wkk.everyday.june;

import com.common.structure.ListNode;

/**
 * @Time: 2020/6/26上午9:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RemoveDuplicateNodeLCCI {
    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = head;
        ListNode temp, cur;
        while(pre != null){
            temp = pre;
            cur = pre.next;
            while(cur != null){
                if(cur.val == pre.val){
                    cur = cur.next;
                    temp.next = cur;
                }else {
                    temp = cur;
                    cur = cur.next;
                }
            }
            pre = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode node = removeDuplicateNodes(node1);
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);
    }
}
