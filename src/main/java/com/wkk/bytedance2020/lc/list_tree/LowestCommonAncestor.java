package com.wkk.bytedance2020.lc.list_tree;

import com.common.structure.TreeNode;

/**
 * @author kongwiki@163.com
 * @since 2020/8/3下午5:11
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left == null && right == null) {
            return null;
        }
        return root;
    }
}
