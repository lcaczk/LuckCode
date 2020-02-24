package com.wkk.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-2-24下午1:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root){
        List list = new ArrayList();
        preOrder(root, list);
        return list;

    }
    public static void preOrder(TreeNode root, List list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left != null) {
            preOrder(root.left, list);
        }
        if(root.right != null) {
            preOrder(root.right, list);
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        List<Integer> list = BinaryTreePreorderTraversal.preorderTraversal(node1);
        System.out.println(list);
    }
}
