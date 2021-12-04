package com.wkk.interview.bytedance2020;

import com.common.structure.TreeNode;

/**
 * @Time: 2020/7/20上午10:31
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root==p || root ==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right==null){
            return null;
        }
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
