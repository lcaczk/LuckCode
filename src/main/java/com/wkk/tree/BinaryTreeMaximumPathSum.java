package com.wkk.tree;

import com.common.structure.TreeNode;

/**
 * @Time: 20-3-2上午9:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreeMaximumPathSum {
   static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        TreeNode node = new TreeNode(-2);
        TreeNode node6 = new TreeNode(1);
        node.left= node6;

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        int max = maxPathSum(node1);
        System.out.println(max);

    }
}
