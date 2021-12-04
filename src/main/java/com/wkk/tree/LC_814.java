package com.wkk.tree;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/8/23
 */
public class LC_814 {
    public TreeNode pruneTree(TreeNode root) {
        return contiansOne(root) ? root : null;
    }

    private boolean contiansOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = contiansOne(root.left);
        boolean right  = contiansOne(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return root.val == 1 || left || right;
    }
}
