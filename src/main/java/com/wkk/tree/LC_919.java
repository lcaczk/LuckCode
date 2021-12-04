package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/8/21
 */
public class LC_919 {
    List<TreeNode> list = new ArrayList<>();

    public LC_919(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            list.add(t);
            if (t.left != null) queue.offer(t.left);
            if (t.right != null) queue.offer(t.right);
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        list.add(node);
        int parent = list.size() / 2 - 1;
        if (list.size() % 2 == 0) {
            list.get(parent).left = node;
        } else {
            list.get(parent).right = node;
        }
        return list.get(parent).val;
    }

    public TreeNode get_root() {
        return list.isEmpty() ? null : list.get(0);
    }
}
