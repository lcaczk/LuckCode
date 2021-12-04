package com.wkk.interview.bytedance2021.linkedlist;

import com.common.structure.ListNode;

import java.util.Objects;

/**
 * 25 k个一组翻转链表
 * @author weikunkun
 * @since 2021/3/13
 */
public class LC_25 {
    /**
     * 思路：
     * 1. 反转链表
     *  所以在尾部执行头插法
     * 2. 寻找每次翻转链表组的pre和tail
     *  pre.next = tail 终止
     *  内部 在tail节点执行头插法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (Objects.isNull(head) || k <= 0 ) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = pre;
        while (true) {
            int i = 0;
            // 寻找当前组的tail
            while (Objects.nonNull(tail) && i < k) {
                tail = tail.next;
                i++;
            }
            // tail为空时，说明最后的一组的长度<k
            // 无需进行翻转
            if (Objects.isNull(tail)) {
                break;
            }
            // 组内进行翻转
            ListNode flag = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                // 防止断链
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            // 新的一组
            pre = flag;
            tail = pre;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LC_25 lc_25 = new LC_25();
        lc_25.reverseKGroup(node1, 1);
    }
}
