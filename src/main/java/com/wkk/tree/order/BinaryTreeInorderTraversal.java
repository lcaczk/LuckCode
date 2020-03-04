package com.wkk.tree.order;

import com.wkk.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-2-24上午11:07
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List list = new ArrayList();
        inOrder(root, list);
        return list;

    }

    public static void inOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrder(root.right, list);
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = null;
        node1.right = node2;
        node2.left = node3;
        node2.right = null;
        List<Integer> list = BinaryTreeInorderTraversal.inorderTraversal(node1);
        System.out.println(list);


    }
}
