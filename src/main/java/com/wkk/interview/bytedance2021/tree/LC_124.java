package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

/**
 * 124 二叉树中的最大路径和
 * 思路： 详看 https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/shou-hui-tu-jie-hen-you-ya-de-yi-dao-dfsti-by-hyj8/
 * 使用后序遍历
 * @author weikunkun
 * @since 2021/3/16
 */
public class LC_124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        //返回当前子树的最大值
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int innerMax = root.val + left + right;
        max = Math.max(max, innerMax);
        int outerMax = root.val + Math.max(left, right);
        return outerMax < 0 ? 0 : outerMax;
    }
}
