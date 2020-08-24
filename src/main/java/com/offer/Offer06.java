package com.offer;

import com.common.structure.ListNode;

import java.util.LinkedList;

/**
 * 题目：剑指 Offer 06.从尾到头打印链表
 * 题目链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 标签：链表
 * <p>
 * 题目描述：
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 */

class Offer06 {
    public int[] reversePrint(ListNode head) {
        // 用栈保存链表遍历结果
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            stack.add(p.val);
            p = p.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
