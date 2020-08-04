package com.wkk.bytedance2020.lc.list_tree;

import com.wkk.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author kongwiki@163.com
 * @since 2020/8/3下午4:51
 */
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y)->(x.val - y.val));
        for(ListNode node : lists){
            while(node != null){
                queue.offer(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode rear = dummy;
        ListNode cur = null;
        while(!queue.isEmpty()){
            cur = new ListNode(queue.poll().val);
            rear.next = cur;
            rear = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        node7.next = node8;

        ListNode[] a = {node1, node4, node7};
        ListNode node = mergeKLists(a);
        System.out.println(node.val);

    }
}
