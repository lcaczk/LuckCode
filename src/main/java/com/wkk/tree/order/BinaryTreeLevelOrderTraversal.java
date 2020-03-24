package com.wkk.tree.order;

import com.wkk.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Time: 20-3-4下午5:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return results;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int currSize = queue.size();
            List<Integer> out = new LinkedList<Integer>();
            for (int i = 0; i < currSize; i++) {
                TreeNode p = queue.poll();
                out.add(p.val);
                if(p.left != null){
                    queue.add(p.left);
                }
                if(p.right != null){
                    queue.add(p.right);
                }
            }
            results.add(out);
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        List<List<Integer>> lists = levelOrder(node1);
        System.out.println(lists);
    }
}

