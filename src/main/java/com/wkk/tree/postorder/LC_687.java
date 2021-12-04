package com.wkk.tree.postorder;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/6/14
 */
public class LC_687 {
    private int max;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int inner = 1;
        int outer = 1;
        int first = 0;
        int second = 0;
        if (root.left != null) {
            if (root.left.val == root.val) {
                first = left + 1;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val) {
                second = right + 1;
            }
        }
        inner = first + second;
        max = Math.max(max, inner);
        return Math.max(first, second);
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        int[] array = stack.stream().mapToInt(i -> i).toArray();
        for (int i : array) {
            System.out.println(i);
        }
    }
}
