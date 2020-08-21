package com.wkk.tree.bst;

import com.wkk.tree.TreeNode;

import java.util.Stack;

/**
 * @Time: 20-3-4上午9:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public static boolean dfs(TreeNode node, long min_v, long max_v) {
        if (node == null) {
            return true;
        }
        if (node.val <= min_v || node.val >= max_v) {
            return false;
        }

        return dfs(node.left, min_v, node.val) && dfs(node.right, node.val, max_v);
    }

    public boolean isValidateBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root, pre = null;
        stack.push(p);

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null && p.val < pre.val) {
                return false;
            }
            pre = p;
            p = p.right;
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;
        TreeNode node = new TreeNode();
        boolean validBST = isValidBST(node);
        System.out.println(validBST);
        System.out.println(Integer.MAX_VALUE);
    }
}
