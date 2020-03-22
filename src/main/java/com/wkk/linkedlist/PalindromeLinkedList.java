package com.wkk.linkedlist;

import java.util.Stack;

/**
 * @Time: 20-3-18下午7:24
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PalindromeLinkedList {
    private Stack<ListNode> stack = new Stack<>();
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        while (p != null){
            stack.push(p);
            p = p.next;
        }
        while (head != null){
            p  =stack.pop();
            if(p.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 快慢指针法
    public boolean isPalindromeII(ListNode head){
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = slow.next;
        // 反转后半截
        while (last.next!= null){
            ListNode temp = last.next;
            last.next = temp.next;
            temp.next =  slow.next;
            slow.next = temp;
        }

        while (slow.next != null){
            slow = slow.next;
            if(slow.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
