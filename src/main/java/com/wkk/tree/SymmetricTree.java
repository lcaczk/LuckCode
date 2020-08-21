package com.wkk.tree;

/**
 * @Time: 20-3-1下午5:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);

    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
         if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = null;
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = null;
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        boolean symmetricTree = isSymmetric(node1);
        System.out.println(symmetricTree);

    }
}
