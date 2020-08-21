package com.wkk.newcoder.base.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time: 2020/6/28下午12:24
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Tree {

    // ***************************************************
    // 二叉树相关概念及其实现判断
    // ***************************************************

    /**
     * 判断是否是搜索二叉树
     *
     * @param node
     * @return
     */
    public static int preValue = Integer.MIN_VALUE;

    public boolean checkBST(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean isLeftBst = checkBST(node.left);
        if (!isLeftBst) {
            return false;
        }
        if (preValue >= node.val) {
            return false;
        } else {
            preValue = node.val;
        }

        return checkBST(node.right);

    }

    public boolean checkBSTII(TreeNode node) {
        if (node == null) {
            return true;
        }
        TreeNode p = node;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (preValue > p.val) {
                    return false;
                } else {
                    preValue = p.val;
                }
                p = p.right;
            }
        }
        return true;
    }

    public boolean checkBSTIII(TreeNode node) {
        // 1.首先左树是搜索二叉树
        // 2.其次右树是搜索二叉树
        // 3.最后自身 left.max < cur.val < right.min
        if (node == null) {
            return false;
        }
        int max = getMax(node);
        int min = getMin(node);
        return (max < node.val && min > node.val) && (checkBSTIII(node.left) && checkBSTIII(node.right));

    }

    private int getMax(TreeNode node){
        while (node.right != null){
            node = node.right;
        }
        return node.val;

    }
    private int getMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node.val;
    }


    /**
     * 判断是否为完全二叉树
     *
     * @param node
     * @return
     */
    public boolean isTotal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            l = node.left;
            r = node.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 判断是否为满二叉树
     *
     * @param node
     * @return
     */
    public boolean isFul(TreeNode node) {
        // 满足2^h - 1即可
        return true;
    }

    /**
     * 判断是否是平衡二叉树
     *
     * @param node
     * @return 1. 首先左树是平衡二叉树
     * 2. 其次右树是平衡二叉树
     * 3. |最后自身的左右子树高度差| <= 1
     */
    public boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.abs(left - right) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

    }


}
