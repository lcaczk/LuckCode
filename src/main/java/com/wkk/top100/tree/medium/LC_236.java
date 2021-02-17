package com.wkk.top100.tree.medium;

import com.common.structure.TreeNode;

import java.util.Objects;

/**
 * 236 二叉树的最近公共祖先
 * 递归思路
 * @author weikunkun
 * @since 2021/2/17
 */
public class LC_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root) || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        // 1. left != null && right == null --> left
        // 2. left == null && right != null --> right
        // 3. left == null && right == null --> null
        // 4. left != null && right != null --> root;
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left == null && right == null) {
            return null;
        }
        return root;
    }
}
