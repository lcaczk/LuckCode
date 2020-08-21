package com.wkk.tree.property;

import com.common.structure.TreeNode;

/**
 * @Time: 20-3-4下午5:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = helper(root);
        return depth;
    }

    private static int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
