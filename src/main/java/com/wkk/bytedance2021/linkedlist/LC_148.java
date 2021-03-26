package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 148 排序链表
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_148 {
    // 1. 转化为数组 排序
    public ListNode sortListII(ListNode head) {
        List<Integer> array = linked2Array(head);
        quickSort(array);
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int i = 0;
        while (i < array.size()) {
            tail.next = new ListNode(array.get(i));
            tail = tail.next;
            i++;
        }
        return dummy.next;
    }

    private void quickSort(List<Integer> array) {
        quickSort(array, 0, array.size()-1);
    }

    private void quickSort(List<Integer> array, int left, int right) {
        if (left > right) {
            return;
        }
        int position = getPosition(array, left, right);
        quickSort(array, left , position - 1);
        quickSort(array, position + 1, right);

    }

    private int getPosition(List<Integer> array, int left, int right) {
        int number = array.get(left);
        while (left < right) {
            while (left < right && array.get(right) >= number) {
                right--;
            }
            while (left < right && array.get(left) <= number) {
                left--;
            }
            if (left < right) {
                // 交换
            }
        }
        return left;

    }

    private List<Integer> linked2Array(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        return array;
    }
    /**
     * 2. 插入排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
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
}
