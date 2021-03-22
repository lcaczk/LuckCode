package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 122 路径总和
 * @author weikunkun
 * @since 2021/3/21
 */
public class LC_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                return true;
            }
        }
        boolean left = hasPathSum(root.left, sum-root.val);
        boolean right = hasPathSum(root.right, sum-root.val);
        return left || right;
    }

    public boolean hasPathSumII(TreeNode root, int targetSum) {
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
