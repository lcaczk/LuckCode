package com.wkk.bytedance2020;

import com.wkk.tree.TreeNode;

/**
 * @Time: 2020/7/25上午9:59
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Easy_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if((left == null && right == null)){
            return true;
        }
        if((left==null && right != null) || (left!=null && right == null) || (left.val != right.val)){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

}
