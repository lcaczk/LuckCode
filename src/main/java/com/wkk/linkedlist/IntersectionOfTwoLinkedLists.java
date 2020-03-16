package com.wkk.linkedlist;

/**
 * @Time: 20-3-16下午3:36
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null) {
            return null;
        }
        ListNode endA = headA;
        while (endA.next != null) {
            endA = endA.next;
        }
        endA.next = headA;
        ListNode slowII = null;
        // 快慢指针法
        ListNode fast = headB;
        ListNode slow = headB;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                slowII = headB;
                while (slowII != slow){
                    slowII = slowII.next;
                    slow = slow.next;
                }
                break;
            }
        }
        endA.next = null;
        return slowII;

    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node5 = new ListNode(5);
        ListNode node5_2 = new ListNode(5);
        ListNode node0 = new ListNode(0);
        ListNode node1_1 = new ListNode(1);
        node4.next = node1;
        node1.next = node8;
        node8.next = node4;
        node4.next = node5;

        node5_2.next = node0;
        node0.next = node1_1;
        node1_1.next = node8;

        ListNode intersectionNode = getIntersectionNode(node4, node5);
        System.out.println(intersectionNode.val);

    }
}
