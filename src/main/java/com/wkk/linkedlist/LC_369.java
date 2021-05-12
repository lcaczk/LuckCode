package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 369. 给单链表加一
 *用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 *
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 *
 * @since 2021/5/7
 */
public class LC_369 {
    public ListNode plusOne(ListNode head) {
        // 考虑进位问题
        // 使用栈，之后进行+操作
        // 先构成逆序链表，再重新构成逆序链表
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        head = dummy.next;
        int flag = 0;
        int i = 0;
        while (head != null) {
            int val = 0;
            if (i == 0) {
                val = head.val + flag + 1;
            } else {
                val = head.val + flag;
            }
            head.val = val % 10;
            flag = val / 10;
            head = head.next;
            i++;
        }
        head = dummy.next;
        while (head.next != null) {
            head = head.next;
        }
        if (flag != 0) {
            head.next = new ListNode(flag);
        }
        ListNode cur = dummy.next;
        dummy.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println((int)(Math.random() * 3));
        }
        List<Integer> list = new ArrayList<>();
    }
}
