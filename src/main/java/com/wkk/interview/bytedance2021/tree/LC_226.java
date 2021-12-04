package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

/**
 * 226 翻转二叉树
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        changeLeftAndRight(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    private void changeLeftAndRight(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
