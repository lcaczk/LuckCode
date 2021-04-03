package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 122 路径总和
 *
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
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
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

    public boolean hasPathSumIII(TreeNode root, int targetSum) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) {
            return false;
        }
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                targetSum -= p.val;
                if (p.left == null && p.right == null) {
                    if (targetSum - p.val == 0) {
                        return true;
                    }
                }
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                targetSum += p.val;
                p = p.left;
            }
        }
        return false;
    }

    public boolean hasPathSumIV(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.right = node9;
        LC_112 lc_112 = new LC_112();
        lc_112.hasPathSumIII(node1, 22);
    }
}
