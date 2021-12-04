package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 103 二叉树的锯齿形层次遍历
 * @author weikunkun
 * @since 2021/3/14
 */
public class LC_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++ ) {
                p = queue.poll();
                if (level % 2 == 1) {
                    out.add(p.val);
                } else {
                    out.add(0, p.val);
                }
                if (Objects.nonNull(p.left)) {
                    queue.offer(p.left);
                }
                if (Objects.nonNull(p.right)) {
                    queue.offer(p.right);
                }
            }
            result.add(out);
            out = new ArrayList<>();
        }
        return result;
    }
}
