package com.wkk.everyday.aug;

import com.wkk.linkedlist.ListNode;
import com.wkk.tree.TreeNode;

/**
 * @author kongwiki@163.com
 * @since 2020/8/18上午8:46
 */
public class ConvertSortedListToBinarySearchTree {
    /**
     * 可以按照有序数组的思路进行转换
     * 需要添加一个按照索引位置获取节点的方法
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        int len = getLen(head);
        return helper(head, 0, len-1);

    }

    private TreeNode helper(ListNode head, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(findNode(mid, head).val);
        node.left = helper(head, left, mid-1);
        node.right = helper(head, mid+1, right);
        return  node;

    }

    private ListNode findNode(int index, ListNode head){
        ListNode node = head;
        while(index > 0){
            node = node.next;
            index--;
        }
        return node;
    }

    private int getLen(ListNode head){
        int n = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree tree = new ConvertSortedListToBinarySearchTree();
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        TreeNode node = tree.sortedListToBST(node1);
        System.out.println(node.val);

    }
}
