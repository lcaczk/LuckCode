package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 题目：翻转二叉树
 * <p>
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 * 思路：1. 递归（艰难的理解）
 *      2. 非递归方式（树的层次遍历）
 *         在进行层次遍历的同时，交换二叉树的左右节点即可
 * </p>
 * @author kongwiki@163.com
 * @since 2020/9/16 10:20 下午
 */

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTreeII(TreeNode root){
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()){
            // 注意使用改形式的层次遍历需要考虑到size提前定义的问题
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                // 三元交换
                TreeNode temp = p.left;
                p.left = p.right;
                p.right = temp;

                if(p.left != null){
                    queue.offer(p.left);
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
            }
        }
        return root;
    }
}
