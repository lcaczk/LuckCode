package com.wkk.tree;

import com.common.structure.TreeNode;

/**
 * @Time: 20-4-11下午8:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;

    }
    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, (left+right));
        return Math.max(left, right) + 1;

    }
}
