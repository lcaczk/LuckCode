package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为二叉搜索树和完全二叉树
 * @author weikunkun
 * @since 2021/6/29
 */
public class JudgeTotalAndSearch {
    private int pre = Integer.MIN_VALUE;
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        if (root == null) {
            return new boolean[] {true, true};
        }
        boolean[] ans = new boolean[2];
        ans[0] = judgeSearchTree(root);
        ans[1] = judgeTotalTree(root);
        return ans;
    }

    private boolean judgeSearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!judgeSearchTree(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return judgeSearchTree(root.right);
    }

    private boolean judgeTotalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.offer(p);
        boolean reachEnd = false;
        while (!queue.isEmpty()) {
            p = queue.poll();
            if (reachEnd && p != null) {
                return false;
            }
            if (p == null) {
                reachEnd = true;
                continue;
            }
            queue.offer(p.left);
            queue.offer(p.right);
        }
        return true;
    }
}
