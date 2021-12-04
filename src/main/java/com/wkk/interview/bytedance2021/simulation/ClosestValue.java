package com.wkk.interview.bytedance2021.simulation;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/4/8
 */
public class ClosestValue {
    public int closestValue(TreeNode root, double target) {
        // 直接使用前序遍历
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (pre <= target && p.val > target) {
                    return Math.abs(pre - target) < Math.abs(p.val - target) ? (int)pre : p.val;
                }
                pre = p.val;
                p = p.right;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;
        ClosestValue value = new ClosestValue();
        value.closestValue(node1, 0.111);
        System.out.println(-1/10);
    }
}
