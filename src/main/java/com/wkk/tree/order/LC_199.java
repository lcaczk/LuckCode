package com.wkk.tree.order;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 199 二叉树的右视图
 *
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        TreeNode p = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                // 每一层的最后一个节点
                if (i == size - 1) {
                    result.add(p.val);
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return result;
    }
}
