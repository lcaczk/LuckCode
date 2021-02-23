package com.wkk.tree.order;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 107 二叉树的层序遍历II
 * 思路 层次遍历
 * 根据list的特性，每次新增一层的结果的时，都在首位插入，即可完成逆序存储
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                p = queue.poll();
                out.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            result.add(0, out);
            out = new ArrayList<>();
        }
        return result;
    }
}
