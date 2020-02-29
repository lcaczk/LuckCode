package com.wkk.tree;

import com.wkk.linkedlist.ListNode;

/**
 * @Time: 20-2-27上午10:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConvertSortedListToBinarySearchTree {
    public static TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode pre = head;
        while (pre != null) {
            length++;
            pre = pre.next;
        }
        TreeNode root = buildTree(head, length);
        return root;

    }

    public static TreeNode buildTree(ListNode node, int length) {
        while (node == null || length <=0){
            return null;
        }
        int mid = length / 2;
        ListNode pre  = node;
        while (mid >0){
            pre = pre.next;
            mid--;
        }
        TreeNode midTreeNode = new TreeNode(pre.val);
        midTreeNode.left = buildTree(node,length/2);
        midTreeNode.right = buildTree(pre.next, length - length/2-1);
        return midTreeNode;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        TreeNode node = sortedListToBST(node1);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);

    }
}
