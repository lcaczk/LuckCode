package com.wkk.dp;

import com.common.structure.TreeNode;

/**
 * 打家劫舍 III
 * @author weikunkun
 * @since 2021/4/12
 */
public class LC_337 {
    public int rob(TreeNode root) {
        int[] res = postOrder(root);
        return Math.max(res[0], res[1]);
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);
        int[] res = new int[2];
        // 不偷当前节点
        int first = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点
        int second = root.val+left[0]+right[0];
        res[0] = first;
        res[1] = second;
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        LC_337 lc_337 = new LC_337();
        lc_337.rob(node1);
    }
}
