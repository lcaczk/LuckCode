package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_543 {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        ans = 0;
        depth(root);
        return ans-1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, (left+right+1));
        return Math.max(left, right) + 1;
    }
}
