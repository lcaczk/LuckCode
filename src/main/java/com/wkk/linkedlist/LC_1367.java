package com.wkk.linkedlist;

import com.common.structure.ListNode;
import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/5/8
 */
public class LC_1367 {
    private static ListNode pre;
    public static boolean isSubPath(ListNode head, TreeNode root) {
        // 思路 前序遍历
        if (root == null || head == null) {
            if (root == null && head == null) {
                return true;
            }
            return false;
        }
        pre = head;
        preOrder(root);
        return pre == null;
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val == pre.val) {
            pre = pre.next;
        }
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(6);
        node1.next = node2;
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;

        isSubPath(node1, treeNode1);
    }
}
