package com.wkk.tree.order;

import com.common.structure.TreeNode;

/**
 * 872. 叶子相似的树
 * @author weikunkun
 * @since 2021/5/10
 */
public class LC_872 {
    private boolean flag = true;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 层次遍历
        if (root1 == null || root2 == null) {
            if (root1 == null && root2 == null) {
                return true;
            }
            return false;
        }
        inOrder(root1, root2);
        return flag;
    }

    private void inOrder(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            if (root1 == null && root2 == null) {
                flag = true;
                return;
            }
            flag = false;
            return;
        }

        inOrder(root1.left, root2.left);
        inOrder(root1.right, root2.right);
        if (isLeafNode(root1) && isLeafNode(root2)) {
            if (root1.val !=  root2.val) {
                flag = false;
            }
        }
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        LC_872 lc_872 = new LC_872();
        TreeNode fNo1 = new TreeNode(1);
        TreeNode fNo2 = new TreeNode(2);
        TreeNode fNo3 = new TreeNode(3);
        fNo1.left = fNo2;
        fNo1.right = fNo3;

        TreeNode sNo1 = new TreeNode(1);
        TreeNode sNo2 = new TreeNode(2);
        TreeNode sNo3 = new TreeNode(3);
        sNo1.left = sNo3;
        sNo1.right = sNo2;
        System.out.println(lc_872.leafSimilar(fNo1, sNo1));
    }
}
