package com.wkk.tree.property;

import com.wkk.tree.TreeNode;

/**
 * @Time: 20-2-26下午10:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        return Math.abs((heightLeft-heightRight)) < 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
