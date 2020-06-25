package com.wkk.everyday.june;

import com.wkk.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 2020/6/21上午8:11
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        List<Integer> collection = new ArrayList<>();
        helper(root, collection);
        System.out.println(collection);
        int[] dp = new int[collection.size()];
        dp[0] = collection.get(0);
        int max = dp[0];
        for (int i = 1; i < collection.size(); i++) {
            dp[i] = Math.max(collection.get(i), dp[i-1] + collection.get(i));
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum sum = new BinaryTreeMaximumPathSum();
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        TreeNode node = new TreeNode(-2);
        TreeNode node6 = new TreeNode(1);
        node.left= node6;

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        int i = sum.maxPathSum(node);
        System.out.println(i);

    }
}
