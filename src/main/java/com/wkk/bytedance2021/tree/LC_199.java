package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 199 二叉树的右视图
 * @author weikunkun
 * @since 2021/3/16
 */
public class LC_199 {
    public List<Integer> rightSideView(TreeNode root) {
        // 思路 层次遍历
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (i == size-1) {
                    result.add(p.val);
                }
                if (Objects.nonNull(p.left)) {
                    queue.offer(p.left);
                }
                if (Objects.nonNull(p.right)) {
                    queue.offer(p.right);
                }
            }
        }
        return result;
    }
}
