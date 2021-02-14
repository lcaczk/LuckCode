package com.wkk.top100.tree.easy;

import com.common.structure.TreeNode;

/**
 * 翻转二叉树
 * 递归思路：
 * 1. 对于当前节点
 *  1.1 如果不为空则交换左右两个孩子
 *  1.2 如果为空，直接返回，不进行交换
 * 2. 对其左右孩子做同样的处理
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        exchangeLeftAndRight(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    private void exchangeLeftAndRight(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
