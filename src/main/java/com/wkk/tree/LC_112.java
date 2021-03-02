package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 112 路径总和
 *
 * @author weikunkun
 * @since 2021/3/1
 */
public class LC_112 {
    /**
     * 递归思路 前序遍历
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        return help(root, targetSum);
    }

    private boolean help(TreeNode root, int count) {
        if (root.left == null && root.right == null && count == root.val) {
            return true;
        }
        if (root.left != null) {
            count -= root.val;
            if (help(root.left, count)) {
                return true;
            }
            count += root.val;
        }
        if (root.right != null) {
            count -= root.val;
            if (help(root.right, count)) {
                return true;
            }
            ;
            count += root.val;
        }
        return false;
    }

    private boolean hasPathSumII(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            if (Objects.isNull(p.left) && Objects.isNull(p.right)) {
                if (root.val == targetSum) {
                    return true;
                }
            }
            if (Objects.nonNull(p.right)) {
                root.right.val = root.val + root.right.val;
                stack.push(p.right);
            }
            if (Objects.nonNull(p.left)) {
                root.left.val = root.left.val + root.val;
                stack.push(p.left);
            }
        }
        return false;
    }

}
