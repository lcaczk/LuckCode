package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * 类描述: TODO
 *
 * @author weikunkun
 */
public class CodeCrush5032 {

    public static ListNode insert(ListNode head, int value) {
        // 找到结果后插入
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = head;
        while (cur != null && cur.val <= value) {
            pre = cur;
            cur = cur.next;
        }
        ListNode newNode = new ListNode(value);
        newNode.next = cur;
        pre.next = newNode;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = GenLinkedList.genList();
        ListNode cur = listNode;
        while (cur != null) {
            System.out.printf("--->%s", cur.val);
            cur = cur.next;
        }
        ListNode insert = insert(listNode, 5);
        System.out.println();
        cur = listNode;
        while (cur != null) {
            System.out.printf("--->%s", cur.val);
            cur = cur.next;
        }
    }
}
