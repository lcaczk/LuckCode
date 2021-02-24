package com.wkk.tree.order;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 111 二叉树的最小深度
 * 思路： 和二叉的最大深度求法类似
 * 但是最短路径的条件需要注意！！！
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
 *
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_111 {
    /**
     * 深度遍历（后序）
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + right;
        } else if (root.left != null && root.right == null) {
            return 1 + left;
        }
        return Math.min(left, right) + 1;
    }

    /**
     * 广度遍历（层次）
     * @param root
     * @return
     */
    public int minDepthII(TreeNode root) {
        int count = 0;
        if (Objects.isNull(root)) {
            return count;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                if (p.left == null && p.right == null) {
                    return count;
                }
            }
        }
        return count;
    }

}
