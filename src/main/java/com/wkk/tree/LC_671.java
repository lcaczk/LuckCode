package com.wkk.tree;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/7/27
 */
public class LC_671 {
    private static int ans;
    private static int rootVal;

    /**
     * 利用题意
     * 按照前序遍历 遇到第一个第二小的元素即可
     * @param root
     * @return
     */
    public static int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        ans = -1;
        dfs(root);
        return ans;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (ans != -1 && root.val >= ans) {
            return;
        }
        if (root.val > rootVal) {
            ans = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        findSecondMinimumValue(node1);
    }
}
