package com.wkk.top100.linkedlist.medium;

import com.common.structure.ListNode;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/2/17
 */
public class LC_148 {
    public ListNode sortList(ListNode head) {
        // 1. 转化为数组 排序
        // 2. 在链表的基础 排序
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int[] result = genList2Array(head);
        Arrays.sort(result);
        int len = result.length;
        int i = 0;
        // 尾插法
        while(i < len) {
            pre.next = new ListNode(result[i++]);
            pre = pre.next;
        }
        return dummy.next;

    }

    /**
     * 链表的插入排序
     * @param head
     * @return
     */
    public ListNode sortListI(ListNode head) {
        // 1. 转化为数组 排序
        // 插入排序
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(head != null) {
            while(pre.next != null && pre.next.val <= head.val) {
                pre = pre.next;
            }
            ListNode temp = head.next;
            // 插入对应的位置
            head.next = pre.next;
            pre.next = head;
            pre = dummy;
            head = temp;
        }
        return dummy.next;
    }

    private int[] genList2Array(ListNode head) {
        ListNode cur = head;
        int[] array = new int[getListLength(head)];
        int i = 0;
        while (cur != null) {
            array[i++] = cur.val;
            cur = cur.next;
        }
        return array;
    }

    private int getListLength(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;

    }
}
