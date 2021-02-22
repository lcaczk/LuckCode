package com.wkk.top100.tree.medium;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 思路： 辅助队列
 *
 * @author weikunkun
 * @since 2021/2/21
 */
public class LC_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 初始化
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        // 校验
        if (Objects.isNull(root)) {
            return result;
        }
        // 使用队列进行辅助
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
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
                out.add(p.val);
            }
            result.add(out);
            out = new ArrayList<>();
        }
        return result;

    }
}
