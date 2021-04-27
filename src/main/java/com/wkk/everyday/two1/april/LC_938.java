package com.wkk.everyday.two1.april;

import com.common.structure.TreeNode;

/**
 * 938 二叉树搜索树的范围和
 * @author weikunkun
 * @since 2021/4/27
 */
public class LC_938 {
    private int sum = 0;
    private int low;
    private int high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        this.low = low;
        this.high = high;
        inOrder(root);
        return sum;

    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }
        inOrder(root.right);
    }

}
