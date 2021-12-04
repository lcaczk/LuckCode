package com.wkk.dfs;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/6/3
 */
public class BinaryTreeMinimumDistance {
    private static TreeNode pre = null;
    private static int min = Integer.MAX_VALUE;
    public static int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrder(root);
        return min;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre == null) {
            pre = root;
        } else {
            min = Math.min(root.val - pre.val, min);
            pre = root;
        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(27);
        TreeNode node2 = new TreeNode(34);
        TreeNode node3 = new TreeNode(58);
        TreeNode node4 = new TreeNode(50);
        TreeNode node5 = new TreeNode(44);
        node1.right = node2;
        node2.right = node3;
        node3.left = node4;
        node4.left = node5;
        minDiffInBST(node1);
    }
}
