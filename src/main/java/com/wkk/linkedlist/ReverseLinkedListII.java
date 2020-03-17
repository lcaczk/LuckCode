package com.wkk.linkedlist;

/**
 * @Time: 20-3-17上午9:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n - m == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre  = dummy;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node = GenLinkedList.genList();
        ListNode node1 = reverseBetween(node, 1, 2);
        System.out.println(node1.val);

    }
}
