package com.wkk.top100.linkedlist.easy;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 234 回文链表
 * @author weikunkun
 * @since 2021/2/15
 */
public class LC_234 {
    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head)) {
            return true;
        }
        // 链表对半，然后判断是否相同
        int len = genListNodeLen(head);
        ListNode halfHead = null;
        if (len%2 == 0) {
            halfHead = genHalfListNode(head, len/2);
        } else {
            halfHead = genHalfListNode(head, len/2+1);
        }
        return judgeSame(head, halfHead);
    }

    private boolean judgeSame(ListNode firstHead, ListNode secondHead) {
        boolean same = true;
        while(secondHead != null) {
            if (!Objects.equals(secondHead.val, firstHead.val)){
                same = false;
                break;
            }
            secondHead = secondHead.next;
            firstHead = firstHead.next;
        }
        return same;
    }

    private ListNode genHalfListNode(ListNode head, int index) {
        ListNode newHead = head;
        while (index > 0) {
            newHead = newHead.next;
            index--;
        }
        ListNode dummy = new ListNode(-1);
        while(newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = dummy.next;
            dummy.next = newHead;
            newHead = temp;
        }
        return dummy.next;
    }

    private int genListNodeLen(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public boolean isPalindromeII(ListNode head) {
        if (Objects.isNull(head)) {
            return true;
        }
        // 快慢指针法
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 还需要逆序转化后半部分的链表...
        slow = slow.next;
        while(slow != null) {
            if (!Objects.equals(slow.val, head.val)) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LC_234 lc_234 = new LC_234();
        lc_234.isPalindromeII(node1);
    }
}
