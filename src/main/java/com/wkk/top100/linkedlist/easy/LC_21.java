package com.wkk.top100.linkedlist.easy;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode rear = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                rear.next = l1;
                l1 = l1.next;
            } else {
                rear.next = l2;
                l2 = l2.next;
            }
            rear = rear.next;
        }
        // 长的链表继续补齐
//        while (l1 != null) {
//            rear.next = l1;
//            rear = rear.next;
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            rear.next = l2;
//            rear = rear.next;
//            l2 = l2.next;
//        }
        if (l1 != null) {
            rear.next = l1;
        }
        if (l2 != null) {
            rear.next = l2;
        }
        return dummy.next;
    }
}
