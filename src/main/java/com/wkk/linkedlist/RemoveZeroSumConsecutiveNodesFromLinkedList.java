package com.wkk.linkedlist;

/**
 * @Time: 20-3-22下午12:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        // fast开始遍历链表
        while (slow.next != null) {
            int sum = fast.val;
            while (sum != 0 && fast.next != null) {
                fast = fast.next;
                sum += fast.val;
            }
            if (sum == 0) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = slow.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        GenLinkedList.genList();
    }
}
