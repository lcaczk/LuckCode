package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * @author weikunkun
 * @since 2021/5/12
 */
public class LC_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (Objects.isNull(head)) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur;
        while (pre.next != null) {
            cur = pre.next;
            while (cur != null && cur.val == val) {
                cur = cur.next;
            }
            if (pre.next != cur) {
                pre.next = cur;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    /**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsII(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 不添加虚拟节点方式
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsIII(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
