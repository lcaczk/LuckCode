package com.wkk.everyday.oct;

import com.common.structure.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目: 两数之和
 * 题目链接: https://leetcode-cn.com/problems/add-two-numbers/submissions/
 * 思路: 读懂题目，然后思考使用queue｜stack进行存储，最后使用头插法｜尾插法
 * @author kongwiki@163.com
 * @since 2020/10/4
 */
public class AddTwoSum {
    // 翻译： 从尾到头存储数据，然后开始进行加法操作，最后使用头插法即可
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> queue1 = linked2Queue(l1);
        Queue<ListNode> queue2 = linked2Queue(l2);
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode rear = dummy;
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            int a = queue1.isEmpty() ? 0 : queue1.poll().val;
            int b = queue2.isEmpty() ? 0 : queue2.poll().val;
            int temp = a + b + carry;
            ListNode cur = new ListNode(temp%10);
            rear.next = cur;
            rear = cur;
            carry = temp/10;
        }
        // 最后处理最高位
        if(carry > 0) {
            ListNode cur = new ListNode(carry);
            rear.next = cur;
            rear = cur;
        }
        return dummy.next;
    }
    private Queue<ListNode> linked2Queue(ListNode node){
        Queue<ListNode> queue = new LinkedList<>();
        while(node != null){
            queue.offer(node);
            node = node.next;
        }
        return queue;
    }
}
