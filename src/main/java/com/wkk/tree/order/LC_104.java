package com.wkk.tree.order;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 104 二叉树的最大深度
 *
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_104 {
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        TreeNode p = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(p);
        int count = 0;
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
            }
        }
        return count;
    }

    public int maxDepthII(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = maxDepthII(root.left);
        int right = maxDepthII(root.right);
        return Math.max(left, right) + 1;
    }
}
