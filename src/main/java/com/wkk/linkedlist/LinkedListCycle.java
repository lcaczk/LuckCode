package com.wkk.linkedlist;

import java.util.HashSet;

/**
 * @Time: 20-2-22下午9:36
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LinkedListCycle {
    //1 使用set(没有重复  但是会浪费内存空间)
    // 时间复杂度 O(n) 空间复杂度O(n)
    public static boolean hasCycle(ListNode head) {
        HashSet set = new HashSet();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // 第二种 使用两个指针
    public static boolean hasCycleII(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            if(fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = ConstructNode.testNode();
        boolean b = hasCycleII(node);
        System.out.println(b);
    }
}
