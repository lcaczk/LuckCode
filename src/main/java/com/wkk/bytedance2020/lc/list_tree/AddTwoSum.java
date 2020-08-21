package com.wkk.bytedance2020.lc.list_tree;

import com.common.structure.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author kongwiki@163.com
 * @since 2020/8/3下午3:13
 */
public class AddTwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 队列+尾插法
        Queue<ListNode> queue1 = list2queue(l1);
        Queue<ListNode> queue2 = list2queue(l2);
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode rear = dummy;
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            int a = queue1.isEmpty() ? 0 : queue1.poll().val;
            int b = queue2.isEmpty() ? 0 : queue2.poll().val;
            int temp = (a + b + carry);
            int i = temp % 10;
            carry = temp / 10;
            ListNode cur = new ListNode(i);
            rear.next = cur;
            rear = cur;
        }
        if(carry > 0){
            ListNode cur = new ListNode(carry);
            rear.next = cur;
            rear = cur;
        }
        return dummy.next;

    }

    private Queue<ListNode> list2queue(ListNode head){
        Queue<ListNode> queue = new ArrayDeque<>();
        while(head != null){
            queue.offer(head);
            head = head.next;
        }
        return queue;
    }
}
