package com.wkk.bytedance2021.simulation;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/4/4
 */
public class FindTilt {
    // 后序遍历
    private int total = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return total;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int diff = Math.abs(left - right);
        total += diff;
        return root.val + left + right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        FindTilt findTilt = new FindTilt();
        findTilt.findTilt(node1);
    }
}
