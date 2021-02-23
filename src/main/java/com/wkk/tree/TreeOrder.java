package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 二叉树的遍历
 *
 * @author weikunkun
 * @since 2021/2/23
 */
public class TreeOrder {
    //递归前序遍历
    public void preOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        // do something
        preOrder(root.left);
        preOrder(root.right);
    }
    //非递归前序遍历
    public void preOrderII(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                // do something
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
               p = stack.pop();
               p = p.right;
            }

        }
    }

    //递归中序遍历
    public void inOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        inOrder(root.left);
        // do something
        inOrder(root.right);
    }
    //非递归中序遍历
    public void inOrderII(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                // do something
                p = p.right;
            }
        }
    }
    //递归后序遍历
    public void postOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        // do something
    }
    //非递归后序遍历
    public void postOrderII(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> list = new ArrayDeque<>();
        Deque<TreeNode> reverse = new ArrayDeque<>();
        TreeNode p = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            list.push(p);
            if (p.right != null) {
                stack.push(p.left);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        while (!list.isEmpty()) {
            reverse.add(list.pop());
        }
    }

    //层次遍历
    public void levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
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
            }
        }
    }

}
