package com.wkk.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time: 20-3-1下午8:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CountCompleteTreeNodes {
    public static int countNodesLevelOrder(TreeNode root) {
        if (root == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
                count++;
            }
            if (p.right != null) {
                queue.offer(p.right);
                count++;
            }

        }
        return count;
    }

    public static int countNodesRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1 + countNodesRecursive(root.left) + countNodesRecursive(root.right);
        return count;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        int count = countNodesRecursive(node1);
        System.out.println(count);
    }

}
