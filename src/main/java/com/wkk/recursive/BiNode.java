package com.wkk.recursive;

import com.wkk.tree.TreeNode;

/**
 * @Time: 2020/6/25下午2:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BiNode {
    private TreeNode head, pre;

    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = null;
        pre = root;
        inOrder(root.right);
    }
}
