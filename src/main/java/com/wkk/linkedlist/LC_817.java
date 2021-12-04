package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/6/17
 */
public class LC_817 {
    public int numComponents(ListNode head, int[] nums) {
        // 思路：
        // 最长连续结点的值
        // set 存储nums
        // 遍历链表
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode cur = head;
        int count = 0;
        boolean flag = false;
        while (cur != null) {
            while(cur != null && set.contains(cur.val)) { // 包含 继续执行
                flag = true;
                cur = cur.next;
            }
            if (flag) {
                count++;
            }
            flag =false;
            if (cur == null){
                break;
            }
            cur = cur.next;
        }
        return count;
    }


}
