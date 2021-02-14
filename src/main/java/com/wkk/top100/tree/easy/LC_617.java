package com.wkk.top100.tree.easy;

import com.common.structure.TreeNode;

/**
 * 合并二叉树
 * 递归思想：
 * 1. 处理同等级的节点
 * 1.1 正常情况，两节点值相加生成新节点
 * 1.2 如果仅一个不为空，返回对应的节点
 * 1.3 如果全为空，返回null
 *
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            if (root1 == null && root2 == null) {
                return null;
            }
            return root1 == null ? root2 : root1;
        }
        int cur = genVal(root1, root2);
        TreeNode root = new TreeNode(cur);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    private int genVal(TreeNode left, TreeNode right) {
        return left.val + right.val;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node1_1 = new TreeNode(3);
        TreeNode node1_2 = new TreeNode(2);
        TreeNode node1_3 = new TreeNode(5);
        node1.left = node1_1;
        node1.right = node1_2;
        node1_1.left = node1_3;

        TreeNode node2 = new TreeNode(2);
        TreeNode node2_1 = new TreeNode(1);
        TreeNode node2_2 = new TreeNode(3);
        TreeNode node2_3 = new TreeNode(4);
        TreeNode node2_4 = new TreeNode(7);
        node2.left = node2_1;
        node2.right = node2_2;
        node2_1.right = node2_3;
        node2_2.right = node2_4;

        LC_617 lc_617 = new LC_617();
        lc_617.mergeTrees(node1, node2);

    }
}
