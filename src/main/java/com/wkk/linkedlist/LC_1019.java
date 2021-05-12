package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/5/7
 */
public class LC_1019 {
    private Map<Integer, Integer> map = new HashMap<>();
    public int[] nextLargerNodes(ListNode head) {
        // 单调栈
        if (head == null) {
            return new int[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int len = genLen(head);
        int[] res = new int[len];
        int i = 0;
        while (head != null) {
            while (!stack.isEmpty() && map.get(stack.peek()) < head.val) {
                int idx = stack.pop();
                res[idx] = head.val;
            }
            stack.push(i);
            i++;
            head = head.next;
        }
        return res;
    }

    private int genLen(ListNode head) {
        int len = 0;
        while (head != null) {
            map.put(len, head.val);
            len++;
            head = head.next;
        }
        return len;
    }
}
