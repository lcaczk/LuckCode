package com.wkk.dfs;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/7/17
 */
public class BinaryTreeIsSubTreeStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            if (A == null && B == null) {
                return true;
            }
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        boolean left = dfs(a.left, b.left);
        boolean right = dfs(a.right, b.right);
        return left && right;
    }
}
