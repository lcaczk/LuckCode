package com.wkk.tree.postorder;

import com.common.structure.TreeNode;

/**
 * 后续遍历
 * 思路类似于路径问题
 * 需要清楚： 当前层能够得出什么最优解，
 *           向上传递的时候，需要传递什么值
 * @author weikunkun
 * @since 2021/6/13
 */
public class LC_298 {
    private int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int inner = 1;
        int outer = 1;
        if (root.left != null && root.left.val - 1 == root.val) {
            inner = Math.max(left +1, inner);
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            inner = Math.max(right + 1, inner);
        }
        max = Math.max(inner, max);
        return inner;
    }
}
