package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.Objects;

/**
 * 110. 平衡二叉树
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_110 {
    public boolean isBalanced(TreeNode root) {
        // 思路 后序遍历
        // 当前节点平衡 && 左子树平衡 && 右子树平衡
        if (Objects.isNull(root)) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}
