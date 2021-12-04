package com.wkk.dfs;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/7/17
 */
public class BinaryTreeisSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            if (root == null && subRoot == null) {
                return true;
            }
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSame(root, subRoot);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            }
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSame(p.left, q.left);
        boolean right = isSame(p.right, q.right);
        return left && right;
    }
}
