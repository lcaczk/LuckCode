package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.Objects;

/**
 * 236 二叉树的最近公共祖先
 * @author weikunkun
 * @since 2021/3/16
 */
public class LC_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root) || p == root || q == root) {
            return root;
        }
        // 1. p q分别在root的左右子树中
        // 2. p=root q在root的左右子树中
        // 3. q = root p在root的左右子树中
        // 4. root = null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right == null) {
            return null;
        }
        return root;
    }
}
