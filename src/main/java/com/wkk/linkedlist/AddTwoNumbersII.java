package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.Stack;

/**
 * @Time: 20-3-21下午11:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        Stack<ListNode> s1 = new Stack();
        while(l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        Stack<ListNode> s2 = new Stack();
        while(l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode resNode = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop().val;
            int n2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = n1 + n2 + carry;
            ListNode n = new ListNode(sum % 10);
            n.next = resNode;
            //make current node our result
            resNode = n;
            carry = sum / 10;
        }
        //take care of remainder
        if (carry > 0) {
            ListNode n = new ListNode(carry);
            n.next = resNode;
            resNode = n;
        }
        return resNode;
    }
}
