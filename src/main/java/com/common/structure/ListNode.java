package com.common.structure;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @Time: 20-2-22下午4:12
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode numsToListNode(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int n : nums) {
            p.next = new ListNode(n);
            p = p.next;
        }
        return head.next;
    }

    public static void printListNode(ListNode head) {
        LinkedList<Integer> res = new LinkedList<>();
        ListNode p = head;
        while (!Objects.isNull(p)) {
            res.addLast(p.val);
            p = p.next;
        }
        System.out.println(res.toString());
    }
}
