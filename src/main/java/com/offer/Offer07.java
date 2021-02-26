package com.offer;

import com.common.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：剑指 Offer 07.重建二叉树
 * 题目链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 标签：树 递归
 * <p>
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * //     3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

class Offer07 {
    // 存放中序遍历节点索引
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(preorder, inorder, 0, 0, inorder.length - 1);
    }

    TreeNode recur(int[] preorder, int[] inorder, int preLeft, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        // 前序节点作为根节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 根据前序节点找到中序位置
        int inIndex = map.get(preorder[preLeft]);
        // 左子树节点个数
        int numLeft = inIndex - inLeft;
        // preLeft加1，中序从inLeft到inIndex减1
        root.left = recur(preorder, inorder, preLeft + 1, inLeft, inIndex - 1);
        // preLeft加左子树节点个数再加一，中序从inIndex加1到inRight
        root.right = recur(preorder, inorder, preLeft + numLeft + 1, inIndex + 1, inRight);
        return root;
    }

    /**
     * 更加简明的思路
     * 可以根据该思路稍作修改，作为中序+后序构成二叉树的方式
     * @param preorder
     * @param inorder
     * @return
     */
    private int start = 0;
    private int[] preOrder;
    private int[] inOrder;
    private static final Map<Integer, Integer> currentMap = new HashMap<>(16);
    public TreeNode buildTreeII(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        for (int i = 0; i < inOrder.length; i++) {
            currentMap.put(inOrder[i], i);
        }
        return helper(0, inOrder.length-1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preOrder[start];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        start++;
        root.left = helper(left, index - 1);
        root.right = helper(index + 1, right);
        return root;
    }
}

























