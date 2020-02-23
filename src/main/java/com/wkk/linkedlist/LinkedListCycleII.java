package com.wkk.linkedlist;


import java.util.HashSet;

/**
 * @Time: 20-2-23上午9:52
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head){
        HashSet set  = new HashSet();
        while (head != null){
            if (set.contains(head)){
                return head;
            }else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public static  ListNode detectCycleII(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                ListNode slowII = head;
                while (slow != slowII){
                    slow = slow.next;
                    slowII = slowII.next;
                }
                return slow;
            }

        }
        return null;
    }
    public static void main(String[] args) {
        ListNode node = ConstructNode.testNode();
        ListNode node1 = detectCycleII(node);
        System.out.println(node1.val);
    }
}
