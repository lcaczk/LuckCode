package com.wkk.top100.tree.easy;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * 思路：
 * 1. 使用一个辅助队列，用于存储每一层的节点
 * 2. 每遍历一层，count+1
 *
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_104 {

    public int maxDepthII(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = maxDepthII(root.left);
        int right = maxDepthII(root.right);
        return Math.max(left, right) + 1;
    }
    /**
     * 广度遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            count++;
        }
        return count;
    }
}
