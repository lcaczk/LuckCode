package com.wkk.everyday.july;

import com.wkk.tree.TreeNode;

/**
 * @Time: 2020/7/3上午9:11
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

    private static TreeNode helper(int[] nums, int low, int height) {
        if(low > height){
            return null;
        }
        int mid = (low + height) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid-1);
        root.right = helper(nums, mid+1, height);
        return root;
    }

    public static void main(String[] args) {
        int[] arrs = {1,2,3,4,5,6};
        TreeNode treeNode = sortedArrayToBST(arrs);
        System.out.println(treeNode.val);

    }
}
