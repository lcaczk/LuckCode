package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

/**
 * 687. 最长同值路径
 * @author weikunkun
 * @since 2021/4/16
 */
public class LC_687 {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    private static int count = 0;
    public static int longestUnivaluePathII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root);
        return count - 1;
    }

    // arr[0] 向上传递的最大值
    // arr[1] 当前的最长相同路径
    private static int[] postOrder(TreeNode root) {
        int[] array = new int[2];
        if (root == null) {
            return array;
        }
        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);
        array[0] = 1;
        array[1] = 1;
        if (root.left != null && root.left.val == root.val) {
            array[0] = left[0] + 1;
            array[1] = Math.max(left[1] + right[1], 1);
        }
        if (root.right != null && root.right.val == root.val) {
            array[0] += Math.max(array[0], right[0] + 1);
            array[1] += Math.max(array[1], (left[1] + right[1]));
        }
        // 当前最大
        count = Math.max(array[1], count);
        return array;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        node5.left = node8;
        longestUnivaluePathII(node1);
    }

}
