package com.wkk.linkedlist;

/**
 * @Time: 20-2-23上午10:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReverseNodesInKGroup {
    // 给定k值 将k个节点之间进行交换
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        int i = 0;

        ListNode p = head;
        while (p != null) {
            i++;
            if (i % k == 0) {
                prev = reverse(prev, p.next);
                p = prev.next;
            } else {
                p = p.next;
            }
        }

        return fake.next;
    }
    public static ListNode reverse(ListNode prev, ListNode next){
        ListNode last = prev.next;
        ListNode curr = last.next;

        while(curr != next){
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }

        return last;
    }

    // 给定k值 将前k个节点进行交换
    public static ListNode reverseKGroupII(ListNode head, int k) {
        ListNode stop = head;
        for (int i = 0; i < k; i++) {
            stop = stop.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (k != 0) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
            k--;
        }
        ListNode tail = dummy.next;
        for (int i = 0; i < 3; i++) {
            tail = tail.next;
        }
        tail.next = stop;


        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = ConstructNode.testNode();
        ListNode node1 = ReverseNodesInKGroup.reverseKGroup(node, 3);
        System.out.println(node1.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.next.next.val);
        System.out.println(node1.next.next.next.next.val);

    }
}
