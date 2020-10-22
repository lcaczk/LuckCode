package com.sh.bfs;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 题目：103.二叉树的锯齿形层次遍历
 * 题目链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p>
 * 题目描述：
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * 返回锯齿形层次遍历如下：
 * // [
 * //  [3],
 * //  [20,9],
 * //  [15,7]
 * // ]
 * <p>
 * Related Topics 栈 树 广度优先搜索
 */
class N0103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 标志该层遍历方向
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> listLevel = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                // 根据遍历方向采用头插还是尾插
                if (isLeft) {
                    listLevel.add(cur.val);
                } else {
                    listLevel.addFirst(cur.val);
                }
                if (!Objects.isNull(cur.left)) {
                    queue.add(cur.left);
                }
                if (!Objects.isNull(cur.right)) {
                    queue.add(cur.right);
                }
            }
            res.add(listLevel);
            // 方向取反
            isLeft = !isLeft;
        }
        return res;
    }
}