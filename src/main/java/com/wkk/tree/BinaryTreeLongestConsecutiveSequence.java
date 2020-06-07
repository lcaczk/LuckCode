package com.wkk.tree;

/**
 * @Time: 2020/6/6上午8:48
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 二叉树中最长子序列
public class BinaryTreeLongestConsecutiveSequence {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, null,0);
        return max;
    }

    private void dfs(TreeNode root, TreeNode parent, int len) {
        if(root == null){
            return;
        }
        len = (parent!=null && parent.val+1==root.val)?len+1: 1;
        max = Math.max(len, max);
        dfs(root.left, root, len);
        dfs(root.right, root, len);

    }
}
