package com.wkk.dfs;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/5/2
 */
public class BinaryTreeIsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left == null && right == null) {
                return true;
            }
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean first = dfs(left.left, right.right);
        boolean second = dfs(left.right, right.left);
        return first && second;
    }
}
