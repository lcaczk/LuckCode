package com.wkk.dfs;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/5/2
 */
public class BinaryTreeIsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            }
            return false;
        }
        return isSame(p, q);
    }

    /**
     * 使用的是前序遍历
     * 自顶向下，正常情况一直遍历到最后，若两者都为空，则same
     * @param p
     * @param q
     * @return
     */
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            }
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSame(p.left, q.left);
        boolean right = isSame(p.right, q.right);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node3.right = node4;
        BinaryTreeIsSameTree tree = new BinaryTreeIsSameTree();
        System.out.println(tree.isSameTree(node1, node3));
        List<Integer> list = new ArrayList<>();
    }

}
