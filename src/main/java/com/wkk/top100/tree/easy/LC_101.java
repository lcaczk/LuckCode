package com.wkk.top100.tree.easy;

import com.common.structure.TreeNode;

import java.util.Objects;

/**
 * 101 对称二叉树
 * 递归思想
 * 按照正常思路：
 * 1. 校验
 * 2. 每一层的处理
 * 2.1 对于当前层，判断两个节点A，B的如下，
 *     A.val == B.val && A.left.val == B.right.val && A.right.val == B.left.val
 * 2.2 递归的判断(A.left,B.right) 和 (A.right, B.left)
 *
 * 通过总结发现：
 * 以上每一层的递推公式的判断会引用三层，重新整理如下：
 * 1. 每一层的处理：
 * 1.1 A.val = B.val
 * 1.2 递归下一层 A.left.val = B.right.val && A.right.val = B.left.val
 *
 * 给定一个二叉树，检查它是否是镜像对称的
 *
 * @author weikunkun
 * @since 2021/2/15
 */
public class LC_101 {
    public boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSame(left, right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        }
        boolean result = left.val == right.val;
        return result && isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
