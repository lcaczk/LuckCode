package com.wkk.dfs;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/7/17
 */
public class BinaryTreeIsMirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
