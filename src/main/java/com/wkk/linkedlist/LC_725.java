package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/5/7
 */
public class LC_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        // 先分组，再构造结果
        List<ListNode> res = new ArrayList<>();
        if (root == null) {
            return new ListNode[k];
        }
        int len = getLen(root);
        if (len == 1) {
            ListNode[] temp = new ListNode[k];
            temp[0] = root;
            return temp;
        }
        if (k == 1) {
            return new ListNode[]{root};
        }
        int count = 0;
        int segSize = 0;
        int preSegSize = 0;
        if (len <= k) {
            segSize = preSegSize = 1;
        } else {
            segSize = len / k;
            preSegSize = segSize + 1;
            count = len % k;
        }
        // 找头
        int idx = 0;
        ListNode pre = root;
        ListNode tail = root;
        while (idx < k || count != 0) {
            int seg = segSize;
            int preSeg = preSegSize;
            if (count > 0) {
                tail = pre;
                while (preSeg > 1) {
                    tail = tail.next;
                    preSeg--;
                }
                res.add(pre);
                if (tail == null) {
                    break;
                }
                pre = tail.next;
                tail.next = null;
                count--;
            } else {
                tail = pre;
                if (tail == null) {
                    break;
                }
                while (seg > 1) {
                    tail = tail.next;
                    seg--;
                }
                res.add(pre);
                pre = tail.next;
                tail.next = null;
            }
            idx++;
        }
        ListNode[] array = new ListNode[k];
        idx = 0;
        for (ListNode node : res) {
            array[idx++] = node;
        }
        return array;

    }

    private int getLen(ListNode root) {
        int len = 0;
        while (root != null) {
            len++;
            root = root.next;
        }
        return len;
    }

    public static void main(String[] args) {
        LC_725 lc_725 = new LC_725();
        ListNode node1 = new ListNode(1);
        int i = 1;
        ListNode head = node1;
        while (i <= 9) {
            node1.next = new ListNode(i+1);
            node1 = node1.next;
            i++;
        }
        lc_725.splitListToParts(head, 7);
    }
}
