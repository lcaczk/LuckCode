package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.ArrayList;
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

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return merge(lists, 0, lists.size() - 1);
    }

    public ListNode merge(ArrayList<ListNode> lists, int l, int r) {
        // 左右相等说明不能再分
        if (l == r)
            return lists.get(l);
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    //合并两个有序链表
    public ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                tmp.next = node1;
                node1 = node1.next;
            } else {
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = node1 != null ? node1 : node2;
        return node.next;
    }
}
