package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_230 {
    private List<Integer> result = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (--k == 0) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return -1;
    }
}
