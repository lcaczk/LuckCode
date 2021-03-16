package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

/**
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
        //当前节点为n,对于当前节点来说，最大值可以为n+left,n+right,n,n+left+right 和 n.val
        //上面四项中的一个，但是返回是不能返回第四个的，那种路径是不成立的
        int p = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(max, p);
        int p2 = Math.max(p, root.val + left + right);
        max = Math.max(max, p2);
        return p;
    }
}
