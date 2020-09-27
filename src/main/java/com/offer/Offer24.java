package com.offer;

import com.common.structure.ListNode;

/**
 * 题目：剑指 Offer 24.反转链表
 * 题目链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 标签：链表
 * <p>
 * 题目描述：
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 * <p>
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 */

class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }
        return res;
    }
}