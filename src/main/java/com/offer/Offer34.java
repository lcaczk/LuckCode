package com.offer;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：剑指 Offer 34.二叉树中和为某一值的路径
 * 题目链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * <p>
 * 题目描述：
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * //               5
 * //             / \
 * //            4   8
 * //           /   / \
 * //          11  13  4
 * //         /  \    / \
 * //        7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 提示：
 * 节点总数 <= 10000
 * <p>
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 * Related Topics 树 深度优先搜索
 * 👍 100 👎 0
 */

class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 结果列表
        List<List<Integer>> res = new LinkedList<>();
        // 当前路径
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, sum, res, path);
        return res;
    }

    void dfs(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        System.out.println("path:" + path.toString());
        // 目标和减少
        sum -= root.val;
        // 满足条件
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
            System.out.println("==== path" + path.toString());
        }
        // 左右
        dfs(root.left, sum, res, path);
        dfs(root.right, sum, res, path);
        // 回溯
        path.removeLast();
    }

    public static void main(String[] args) {
        Offer34 solution = new Offer34();
        List<Integer> rootList = new LinkedList<>();
        rootList.add(5);
        rootList.add(4);
        rootList.add(8);
        rootList.add(11);
        rootList.add(null);
        rootList.add(13);
        rootList.add(4);
        rootList.add(7);
        rootList.add(2);
        rootList.add(null);
        rootList.add(null);
        rootList.add(5);
        rootList.add(1);
        TreeNode root = TreeNode.createBinaryTree(rootList);
        solution.pathSum(root, 22);
    }
}