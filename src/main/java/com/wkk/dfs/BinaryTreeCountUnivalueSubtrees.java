package com.wkk.dfs;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/7/13
 */
public class BinaryTreeCountUnivalueSubtrees {
    private int ans = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root);
        return ans;
    }

    private boolean postOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = postOrder(root.left);
        boolean right = postOrder(root.right);
        boolean cur = true;
        boolean sub = true;
        if (root.left != null) {
            if (root.left.val != root.val) {
                sub = false;
            }
        }
        if (root.right != null) {
            if (root.right.val != root.val) {
                sub = false;
            }
        }
        cur = cur & sub & left & right;
        if (cur) {
            ans++;
        }
        return cur;
    }
}
