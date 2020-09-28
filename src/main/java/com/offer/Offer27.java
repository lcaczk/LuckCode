package com.offer;

import com.common.structure.TreeNode;

/**
 * 题目：剑指 Offer 27.二叉树的镜像
 * 题目链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 标签：树
 * <p>
 * 题目描述：
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * //      4
 * //     / \
 * //    2   7
 * //  / \ / \
 * // 1  3 6 9
 * //镜像输出：
 * //       4
 * //      / \
 * //     7  2
 * //   / \ / \
 * //  9  6 3 1
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 限制：
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 */

class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmpLeft = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmpLeft);
        return root;
    }
}