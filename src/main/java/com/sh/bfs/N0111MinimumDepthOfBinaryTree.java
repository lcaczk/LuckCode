package com.sh.bfs;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：111.二叉树的最小深度
 * 题目链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * 题目描述：
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * 返回它的最小深度 2.
 * Related Topics 树 深度优先搜索 广度优先搜索
 */
class N0111MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 叶子节点
                if (cur.left == null && cur.right == null) {
                    return res + 1;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res++;
        }
        return res;
    }
}