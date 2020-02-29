package com.wkk.tree;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time: 20-2-25上午7:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static TreeNode invertTreeII(TreeNode root){
        if(root == null){
            return root;
        }
        else {
            Queue<TreeNode> queue  = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                TreeNode t = poll.left;
                poll.left = poll.right;
                poll.right = t;
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
            return root;
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode node = InvertBinaryTree.invertTree(node1);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
    }
}
