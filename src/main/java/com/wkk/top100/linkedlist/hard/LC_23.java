package com.wkk.top100.linkedlist.hard;

import com.common.structure.ListNode;

import java.util.PriorityQueue;

/**
 * 23 合并k个生序链表
 *
 * @author weikunkun
 * @since 2021/2/18
 */
public class LC_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 构成一个小根堆
        // 然后小根堆构建为一个有序链表
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode cur = new ListNode(queue.poll());
            tail.next = cur;
            tail = tail.next;
        }
        return dummy.next;

    }
}