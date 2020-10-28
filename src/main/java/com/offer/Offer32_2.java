package com.offer;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：剑指 Offer 32 - II.从上到下打印二叉树 II
 * 题目链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * <p>
 * 题目描述：
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 提示：
 * 节点总数 <= 1000
 * <p>
 * 注意：本题与主站 102 题相同：
 * https://leetcode-cn.com/problems/binary-tree-level-order-traersal/
 * Related Topics 树 广度优先搜索
 */

class Offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> resLevel = new LinkedList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                resLevel.add(curNode.val);

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(resLevel);
        }
        return res;
    }
}