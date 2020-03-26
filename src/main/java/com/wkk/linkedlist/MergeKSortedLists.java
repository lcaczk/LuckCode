package com.wkk.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Time: 20-3-26下午1:28
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 尾插法
        ListNode dummy = new ListNode(-1);
        ListNode real = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        while (!heap.isEmpty()) {
            real.next = heap.poll();
            real = real.next;
            if (real.next != null) {
                heap.offer(real.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKListsII(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        int length = lists.length;
        while (length > 1) {
            int k = (length + 1) / 2;
            for (int i = 0; i < (length / 2); i++) {
                lists[i]  = mergeTwo(lists[i], lists[i+k]);
            }
            length = k;
        }
        return lists[0];
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        // 尾插法
        ListNode dummy = new ListNode(-1);
        ListNode real = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                real.next = l1;
                l1 = l1.next;
            } else {
                real.next = l2;
                l2 = l2.next;
            }
            real = real.next;
        }
        if (l1 != null) {
            real.next = l1;
        }
        if (l2 != null) {
            real.next = l2;
        }

        return dummy.next;
    }
}
