package com.wkk.tree.bst;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 230. 二叉搜索树中第K小的元素
 * 思路： 根据二叉搜索树的性质，使用中序遍历
 * @author weikunkun
 * @since 2021/2/25
 */
public class LC_230 {
    private List<Integer> result = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if (Objects.isNull(root)) {
            return -1;
        }
        inOrder(root);
        return result.get(k-1);
    }

    private void inOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }
}
