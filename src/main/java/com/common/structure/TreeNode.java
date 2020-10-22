package com.common.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-2-24上午11:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TreeNode {
    public int val;
    public int count;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        this.count = 0;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 根据序列（层序）构建二叉树
     */
    public static TreeNode createBinaryTree(List<Integer> list) {
        TreeNode root = new TreeNode(list.get(0));
        //层序创建二叉树
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        TreeNode current = null;
        Integer value = null;
        while (i < list.size()) {
            // 从链表中移除并获取第一个节点
            current = queue.poll();
            value = list.get(i++);
            if (value != null && current != null) {
                TreeNode left = new TreeNode(value);
                // 创建当前节点的左孩子
                current.left = left;
                // 在链表尾部 左孩子入队
                queue.offer(left);
            }
            value = list.get(i++);
            if (value != null && current != null) {
                TreeNode right = new TreeNode(value);
                // 创建当前节点的右孩子
                current.right = right;
                // 在链表尾部 右孩子入队
                queue.offer(right);
            }

        }
        return root;
    }

}
