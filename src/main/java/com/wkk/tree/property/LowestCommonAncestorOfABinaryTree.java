package com.wkk.tree.property;

import com.wkk.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @Time: 20-3-6上午9:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<TreeNode>();
        Stack<TreeNode> qStack = new Stack<TreeNode>();
        if(findPath(pStack, root, p) && findPath(qStack, root, q)){
            for (TreeNode node : pStack) {
                if(qStack.contains(node)){
                    return node;
                }
            }
        }
        return null;
    }

    private boolean findPath(Stack<TreeNode> stack, TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        TreeNode q = root;
        stack.push(q);
        while (q != null || !stack.isEmpty()) {
            while (q!=null){
                stack.push(q);
                q = q.left;
            }
            if(!stack.isEmpty()){
                q = stack.pop();
                if(q == target){
                    return true;
                }
                q = q.right;
            }
        }
        return false;
    }
}
