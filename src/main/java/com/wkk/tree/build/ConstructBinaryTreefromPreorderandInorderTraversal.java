package com.wkk.tree.build;

import com.wkk.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time: 20-3-2上午9:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        // 当前根节点所在中序遍历位置
        int inRoot = inMap.get(root.val);
        // 该根节点左边子节点的个数
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, inRoot + 1 , preEnd, inorder, inRoot + 1, inEnd, inMap);
        //TODO

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);
        System.out.println(root.left.val);


    }
}
