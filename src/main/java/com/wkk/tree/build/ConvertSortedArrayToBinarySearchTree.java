package com.wkk.tree.build;

import com.wkk.tree.TreeNode;

/**
 * @Time: 20-2-27上午9:02
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public static TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid-1 );
        node.right = helper(num, mid+1 , high);
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(arr);
        System.out.println(node.val);
        System.out.println(node.left.val);
    }


}
