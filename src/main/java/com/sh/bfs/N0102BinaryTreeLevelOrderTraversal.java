package com.sh.bfs;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 题目：102.二叉树的层序遍历
 * 题目链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 题目描述：
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * 返回其层次遍历结果：
 * // [
 * //  [3],
 * //  [9,20],
 * //  [15,7]
 * // ]
 * <p>
 * Related Topics 树 广度优先搜索
 */
class N0102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> listLevel = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                listLevel.add(cur.val);
                if (!Objects.isNull(cur.left)) {
                    queue.add(cur.left);
                }
                if (!Objects.isNull(cur.right)) {
                    queue.add(cur.right);
                }
            }
            res.add(listLevel);
        }
        return res;
    }
}