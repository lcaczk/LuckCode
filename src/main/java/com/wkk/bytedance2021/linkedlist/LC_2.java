package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/3/18
 */
public class LC_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 思路
        // 按照题意 从个位一直加到最高位，返回的结果是从个位到最高位得到的结果
        // 结果的构造使用尾插法 保证顺序
        // 使用栈来存储每一个链表的数据，进而方便执行相加
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return null;
        }
        Queue<Integer> queue1 = genQueue(l1);
        Queue<Integer> queue2 = genQueue(l2);
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int high = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            int a = queue1.isEmpty() ? 0 : queue1.poll();
            int b = queue2.isEmpty() ? 0 : queue2.poll();
            int cur = (a + b + high);
            ListNode node = new ListNode(cur % 10);
            high = cur / 10;
            tail.next = node;
            tail = tail.next;
        }
        // 补充位数
        if (high != 0) {
            tail.next = new ListNode(high);
            tail = tail.next;
        }
        return dummy.next;
    }

    private Queue<Integer> genQueue(ListNode head) {
        Queue<Integer> queue = new LinkedList<>();
        while (head != null) {
            queue.offer(head.val);
            head = head.next;
        }
        return queue;
    }
}
