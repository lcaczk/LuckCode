package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 958 二叉树的完全性检验
 *
 * @author weikunkun
 * @since 2021/3/20
 */
public class LC_958 {
    // 思路 层次遍历
    public boolean isCompleteTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        // 思路
        // 1. 层次遍历 所有的节点包含空节点
        // 弹出时，如果为空节点，判断队列中是否还有非空节点，如果有则返回false
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            p = queue.poll();
            if (Objects.nonNull(p)) {
                queue.offer(p.left);
                queue.offer(p.right);
            } else {
                p = queue.poll();
                if (Objects.nonNull(p)) {
                    return false;
                } else {
                    while (!queue.isEmpty()) {
                        p = queue.poll();
                        if (Objects.nonNull(p)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 和上述方法一样，但是更加简明
     * @param root
     * @return
     */
    public boolean isCompleteTreeII(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reachedEnd = false;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (reachedEnd && cur != null) {
                return false;
            }
            if (cur == null) {
                reachedEnd = true;
                continue;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        LC_958 lc_958 = new LC_958();
        System.out.println(lc_958.isCompleteTree(node1));
    }
}
