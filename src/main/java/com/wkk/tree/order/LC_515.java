package com.wkk.tree.order;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 515 在每个树行中找最大值
 * 思路 层次遍历
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        TreeNode p = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                max = Math.max(max, p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
    }
}
