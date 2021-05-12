package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1836. 从未排序的链表中删光所有的重复节点
 * @author weikunkun
 * @since 2021/5/8
 */
public class LC_1836 {
    /**
     * 超时
     * 主要原因是为使用缓存机制，存储对应的元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null) {
            return head;
        }
        // 删光
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode flag;
        ListNode cur;
        ListNode innerPre;
        while (pre.next != null) {
            flag = pre.next;
            cur = flag.next;
            innerPre = flag;
            while (true) {
                while (cur != null && cur.val != flag.val) {
                    innerPre = cur;
                    cur = cur.next;
                }
                if (cur == null) {
                    break;
                }
                innerPre.next = cur.next;
                cur = innerPre.next;
                pre.next = flag.next;
            }
            if (pre.next != flag) {
                continue;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    /**
     * 因为上述方法会超时，所以先使用map缓存数据
     * 之后依次遍历，遇到val相同数量>1的直接删除该节点即可
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesUnsortedII(ListNode head) {
        if (head == null) {
            return head;
        }
        // 删光
        Map<Integer, Integer> map = new HashMap<>();
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = head;
        while (pre != null) {
            map.put(pre.val, map.getOrDefault(pre.val, 0) + 1);
            pre = pre.next;
        }

        pre = dummy;
        ListNode cur;
        while (true) {
            cur = pre.next;
            while (cur != null && map.get(cur.val) == 1) {
                pre = cur;
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            // 处理重复节点
            pre.next = cur.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteDuplicatesUnsorted(node1);
    }
}
