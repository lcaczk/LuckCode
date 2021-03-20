package com.wkk.bytedance2021.linkedlist;

import com.common.structure.ListNode;

/**
 * 83 删除链表重复元素（保留一个）
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_83 {
    public ListNode deleteDuplicates(ListNode head) {
        // 思路
        // 考虑到头节点也可能被删除，所以设置假的头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 标记前驱节点
        // 重复之后删除
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next != cur) {
                pre.next = cur;
            }
            pre = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode pre = head;
        ListNode cur;
        while (pre.next != null){
            cur = pre.next;
            // 因为是和cur的前驱比较， 所以不用判断cur.next!=null, 而是使用cur!=null
            while (cur!=null && cur.val == pre.val){
                cur = cur.next;
            }
            if(pre.next != cur){
                pre.next = cur;
            }
            else {
                pre = pre.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

    }
}
