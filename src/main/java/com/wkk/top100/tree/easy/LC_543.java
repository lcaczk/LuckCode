package com.wkk.top100.tree.easy;

import com.common.structure.TreeNode;

import java.util.Objects;

/**
 * 543 二叉树的直径
 * 思路
 * 1.递归求解
 * 直径的意思：以当前的节点为基础，其Max(左子树深度)+Max(右子树深度)
 * ===>在求一颗二叉树的深度的时候，刚好每一次的递归都能获取当前节点的Max(左子树深度)+Max(右子树深度)
 * @author weikunkun
 * @since 2021/2/15
 */
public class LC_543 {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        ans = 0;
        depth(root);
        return ans-1;
    }

    private int depth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left+right);
        return Math.max(left, right) + 1;
    }

}
