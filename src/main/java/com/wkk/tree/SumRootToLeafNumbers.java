package com.wkk.tree;

import com.common.structure.TreeNode;

/**
 * @Time: 20-3-5下午9:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root){
        int results = dfs(root, 0);
        return results;
    }

    private int dfs(TreeNode root, int results) {
        if(root == null){
            return 0;
        }
        results = results*10 + root.val;
        if(root.left == null && root.right == null){
            return results;
        }

        return dfs(root.left, results) + dfs(root.right, results);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        SumRootToLeafNumbers numbers = new SumRootToLeafNumbers();
        int i = numbers.sumNumbers(node1);
        System.out.println(i);

    }
}
