package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @Time: 20-3-18下午7:13
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;

    }
}
