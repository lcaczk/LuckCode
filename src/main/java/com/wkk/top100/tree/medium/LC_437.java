package com.wkk.top100.tree.medium;

import com.common.structure.TreeNode;

import java.util.Objects;

/**
 * 437 路径总和III
 * 思路：递归
 * 1. 双层递归
 *  1.1 总量 = 当前节点数量 + 左子树数量 + 右子树数量
 *  1.2 统计节点数量
 *      1.2.1 入参 节点 sum (类似求路径总和)
 * @author weikunkun
 * @since 2021/2/22
 */
public class LC_437 {
    public int pathSum(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return calculation(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    /**
     * 总量 = 左+右+当前
     * @param root
     * @param sum
     * @return
     */
    private int calculation(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int count = 0;
        if (sum == 0) {
            count += 1;
        }
        int left = calculation(root.left, sum - root.val);
        int right = calculation(root.right, sum - root.val);
        return left + right + count;
    }
}
