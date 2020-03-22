package com.wkk.linkedlist;

/**
 * @Time: 20-3-18下午6:40
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SortList {
    public static ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (head != null) {
            ListNode cur = head.next;
            pre = dummy;
            while (pre.next != null && pre.next.val < head.val){
                pre = pre.next;
            }
            head.next = pre.next;
            pre.next = head;

            head = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = GenLinkedList.genList();
        ListNode node1 = sortList(node);
        System.out.println(node1.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.next.val);
        System.out.println(node1.next.next.next.val);
    }
}
