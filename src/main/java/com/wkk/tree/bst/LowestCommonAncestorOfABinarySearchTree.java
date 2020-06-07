package com.wkk.tree.bst;

import com.wkk.tree.TreeNode;

/**
 * @Time: 20-3-6上午9:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root !=null){
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else {
                break;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorII(root.right, p, q);
        }else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorII(root.left, p, q);
        }
        return root;
    }
}
