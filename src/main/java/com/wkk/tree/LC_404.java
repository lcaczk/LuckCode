package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 404 左叶子之和
 * 思路：层次/后序
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_404 {
    /**
     * 层次
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (Objects.isNull(root)) {
            return sum;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.left != null) {
                    if (p.left.left == null && p.left.right == null) {
                        sum += p.left.val;
                    }
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return sum;
    }

    /**
     * 后序
     * @param root
     * @return
     */
    public int sumOfLeftLeavesII(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int leftSum = sumOfLeftLeavesII(root.left);
        int rightSum = sumOfLeftLeavesII(root.right);

        int cur = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            cur += root.left.val;
        }
        return leftSum + rightSum + cur;
    }
}
