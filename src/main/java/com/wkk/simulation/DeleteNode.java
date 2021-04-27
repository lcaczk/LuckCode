package com.wkk.simulation;

import com.common.structure.TreeNode;

/**
 * @author weikunkun
 * @since 2021/4/27
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        else {
            if (root.val == key) {
                // 1. 删除节点为叶子节点
                //    直接删除
                if (root.left == null && root.right == null) {
                    root = null;
                }
                // 2. 删除节点仅有左子树（右子树）
                //    后继节点上移
                else if (root.left != null && root.right == null) {
                    root = root.left;

                } else if (root.right != null && root.left == null) {
                    root = root.right;
                }
                // 3. 删除节点既有左子树又有右子树
                //    左边： 最右的叶子节点
                //    右边： 最左的叶子节点
                else {
                    TreeNode leftMax = getRightEnrty(root.left);
                    root.val = leftMax.val;
                    TreeNode newLeft = deleteNode(root.left, root.val);
                    root.left = newLeft;
                }


            } else if (root.val < key) {
                root.left = deleteNode(root.right, key);
            } else {
                root.right = deleteNode(root.left, key);
            }
            return root;
        }
    }

    private TreeNode getRightEnrty(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
