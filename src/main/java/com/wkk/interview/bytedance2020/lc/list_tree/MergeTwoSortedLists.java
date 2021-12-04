package com.wkk.interview.bytedance2020.lc.list_tree;

import com.common.structure.ListNode;

/**
 * @author kongwiki@163.com
 * @since 2020/8/3下午2:40
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 使用尾插法
        ListNode dummy = new ListNode(-1);
        ListNode rear = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                rear.next = l1;
                l1 = l1.next;
            }else {
                rear.next = l2;
                l2 = l2.next;
            }
            rear = rear.next;
        }
        if(l1 != null){
            rear.next = l1;
        }
        if(l2 != null){
            rear.next = l2;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node3.next = node4;
        ListNode node = mergeTwoLists(node1, node3);
        System.out.println(node.val);


    }
}
