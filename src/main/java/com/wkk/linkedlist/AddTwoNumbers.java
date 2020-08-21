package com.wkk.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time: 20-3-22下午8:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> queue1 = list2Queue(l1);
        Queue<ListNode> queue2 = list2Queue(l2);
        // 应题目要求 使用尾插发
        ListNode dummy = new ListNode(-1);
        ListNode real = dummy;
        int carry = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            int p1 = queue1.isEmpty() ? 0 : queue1.poll().val;
            int p2 = queue2.isEmpty() ? 0 : queue2.poll().val;
            int sum = p1 + p2 + carry;
            int i = sum % 10;
            ListNode cur = new ListNode(i);
            real.next = cur;
            real = cur;
            carry = sum / 10;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            real.next = node;
            real = node;

        }
        return dummy.next;

    }

    public Queue<ListNode> list2Queue(ListNode node) {
        Queue<ListNode> queue = new LinkedList<>();
        while (node != null) {
            queue.offer(node);
            node = node.next;
        }
        return queue;

    }

    public static void main(String[] args) {

    }
}
