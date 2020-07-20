package com.wkk.bytedance2020;

import com.wkk.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Time: 2020/7/20上午9:36
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_SumListsLCCI {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> q1 = list2Queue(l1);
        Queue<Integer> q2 = list2Queue(l2);
        int carry = 0;
        int cur = 0;
        int sum = 0;
        // 计算 之后按照题意 使用尾插法
        ListNode dummy = new ListNode(-1);
        ListNode rear = dummy;
        while(!q1.isEmpty() || !q2.isEmpty()){
            int a = q1.isEmpty()?0:q1.poll();
            int b = q2.isEmpty()?0:q2.poll();
            sum = a + b + carry;
            cur = sum % 10;
            carry = sum / 10;
            // 构造链表
            ListNode node = new ListNode(cur);
            rear.next = node;
            rear = node;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            rear.next = node;
            rear = node;
        }
        return dummy.next;
    }

    private Queue<Integer> list2Queue(ListNode node){
        Queue<Integer> queue = new ArrayDeque<>();
        while(node != null){
            queue.offer(node.val);
            node = node.next;
        }
        return queue;
    }
}
