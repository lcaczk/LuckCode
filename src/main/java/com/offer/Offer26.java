package com.offer;

import com.common.structure.TreeNode;

/**
 * 题目：剑指 Offer 26.树的子结构
 * 题目链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 标签：树
 * <p>
 * 题目描述：
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * //     3
 * //   /   \
 * //   4    5
 * //  / \
 * // 1   2
 * 给定的树 B：
 * //   4
 * //  /
 * // 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 10000
 */

class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}