package com.wkk.tree.postorder;

import com.common.structure.TreeNode;

/**
 * 后续遍历
 * 同样的思路
 * 需要明确：
 *     1. 在当前层 可以获取的最优结果
 *     2. 需要向上传递的结果是什么
 * @author weikunkun
 * @since 2021/6/13
 */
public class LC_549 {
    private int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        // 0 : 自顶向下增
        // 1 : 自顶向下减
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 1;
        if (root.left != null) {
            if (root.val - 1 == root.left.val) {
                tmp[1] = Math.max(left[1] + 1, tmp[1]);
            } else if (root.val + 1 == root.left.val) {
                tmp[0] = Math.max(left[0] + 1, tmp[0]);
            }
        }
        if (root.right != null) {
            if (root.val - 1 == root.right.val) {
                tmp[1] = Math.max(right[1] + 1, tmp[1]);
            } else if (root.val + 1 == root.right.val) {
                tmp[0] = Math.max(right[0] + 1, tmp[0]);
            }
        }
        max = Math.max(tmp[0] + tmp[1] - 1, max);
        return tmp;
    }
}
