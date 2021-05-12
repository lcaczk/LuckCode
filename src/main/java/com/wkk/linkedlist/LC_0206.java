package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/5/8
 */
public class LC_0206 {
    public boolean isPalindrome(ListNode head) {
        // 思路
        // 获取长度，然后对半截开
        // 使用栈存储后一半的链表，然后依次对比
        // O（n）时间复杂度。O（n）空间复杂度
        if (head == null) {
            return true;
        }
        int len = getLen(head);
        int half = len / 2;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode halfHead = dummy;
        while (half > 0) {
            tail = tail.next;
            half--;
        }
        if (len % 2 == 0) {
            halfHead = tail.next;
        } else {
            halfHead = tail.next.next;
        }
        tail.next = null;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (halfHead != null) {
            stack.push(halfHead);
            halfHead = halfHead.next;
        }
        while (!stack.isEmpty()) {
            if (stack.peek().val != head.val) {
                return false;
            }
            head = head.next;
            stack.pop();
        }
        return true;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {

    }
}
