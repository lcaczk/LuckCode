package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 98. 验证二叉搜索树
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_98 {
    public boolean isValidBST(TreeNode root) {
        // 根据二叉搜索树的性质，使用中序遍历
        TreeNode pre = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (pre != null && pre.val >= p.val) {
                    return false;
                }
                pre = p;
                p = p.right;
            }
        }
        return true;
    }

    public  static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        LC_98 lc_98 = new LC_98();
        lc_98.isValidBST(node1);
    }
}
