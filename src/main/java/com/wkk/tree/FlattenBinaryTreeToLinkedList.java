package com.wkk.tree;

import com.common.structure.TreeNode;

/**
 * @Time: 20-2-29下午8:52
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.right;
        if(node.left != null){
            flatten(node.left);
        }
        if (node.right != null){
            flatten(node.right);
        }
        node.right = node.left;
        node.left = null;
        while (node.right != null) {
            node = node.right;
        }
        node.right = temp;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        flatten(node1);
        System.out.println(node1.left == null);
    }
}
