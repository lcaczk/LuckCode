package com.offer;

/**
 * 题目：剑指 Offer 33.二叉搜索树的后序遍历序列
 * 题目链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * <p>
 * 题目描述：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 参考以下这颗二叉搜索树：
 * //      5
 * //    / \
 * //   2   6
 * //  / \
 * // 1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 提示：
 * 数组长度 <= 1000
 */
class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        // 正常情况下，最后一个节点是根节点，根据根节点划分递归
        int i = left;
        // 比根节点小的是左子树
        while (postorder[i] < postorder[right]) {
            i++;
        }
        int m = i;
        // 比根节点大的是右子树
        while (postorder[i] > postorder[right]) {
            i++;
        }
        return i == right && recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }
}