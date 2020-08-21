package com.wkk.everyday.aug;

import com.wkk.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kongwiki@163.com
 * @since 2020/8/21上午9:22
 */
public class MinimumDepthOfBinaryTree {
    // 层次遍历
    // 当遇到左右孩子均为空的时候, 即为最小深度
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.offer(p);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.right == null && p.left == null) {
                    return count;
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
        node1.left = null;
        node1.right = node2;
        int i = minDepth(node1);
        System.out.println(i);
    }

}
