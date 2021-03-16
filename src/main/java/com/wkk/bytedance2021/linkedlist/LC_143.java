package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 143 重排链表
 * @author weikunkun
 * @since 2021/3/17
 */
public class LC_143 {
    private Map<Integer, ListNode> map = new HashMap<>();
    public void reorderList(ListNode head) {
        // 思路
        // 头插法 需要每次获取尾部节点
        // 使用map 存储对应关系
        // i， node
        int len = getNodeLen(head);
        ListNode cur = head;
        int i = 0;
        while (i < len /2) {
            int nextIdx = len - i - 1;
            ListNode node = map.get(nextIdx);
            ListNode temp = cur.next;
            node.next = cur.next;
            cur.next = node;
            cur = temp;
            i++;
        }
        // 将最后一个元素的next 执行空
        // 避免构成环
        cur.next = null;
    }

    private int getNodeLen(ListNode head) {
        int count = 0;
        while (head != null) {
            map.put(count, head);
            head = head.next;
            count++;
        }
        return count;
    }
    private ListNode getTail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(node1.val);
        iterator(node1);
        System.out.println(node1.val);
    }

    private static void iterator(ListNode head) {
        head = head.next;
    }
}
