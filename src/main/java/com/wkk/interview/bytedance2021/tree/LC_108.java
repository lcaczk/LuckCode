package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

/**
 * 108 将有序数组转换为二叉搜索树
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        //类似根据前序、中序构建二叉树
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }
}
