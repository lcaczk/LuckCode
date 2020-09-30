package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

/**
 * 题目: 二叉搜索树中的插入操作
 * 题目链接: https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * <p>
 * 描述:
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
 * 你可以返回任意有效的结果。
 * <p>
 * 示例:
 *
 * @author kongwiki@163.com
 * @since 2020/9/30 6:48 下午
 */
public class InsertIntoABinarySearchTree {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode p = root;
        TreeNode target = new TreeNode(val);
        if (root == null) {
            return target;
        }
        while (p != null) {
            if (p.val > val) {
                if (p.left == null) {
                    p.left = target;
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = target;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        TreeNode node = insertIntoBST(node1, 5);


    }
}
