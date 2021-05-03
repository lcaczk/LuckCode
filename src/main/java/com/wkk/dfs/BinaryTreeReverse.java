package com.wkk.dfs;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/5/2
 */
public class BinaryTreeReverse {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        reverse(root);
        return root;
    }
    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        reverse(root.left);
        reverse(root.right);
    }

    private void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
