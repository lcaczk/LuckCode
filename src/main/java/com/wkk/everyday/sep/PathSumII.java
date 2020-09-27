package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：路径总合II
 * 题目连接：https://leetcode-cn.com/problems/path-sum-ii/
 * 思路：深度遍历
 * @author kongwiki@163.com
 * @since 2020/9/26 9:01 下午
 */
public class PathSumII {
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> out = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return res;
        }
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        List<Integer> out = new LinkedList<Integer>();
        helper(root, sum);
        return res;
    }

    private static void helper(TreeNode root, int target){
        if(root == null){
            return;
        }
        out.add(root.val);
        if(root.left == null && root.right == null && target == root.val){
            res.add(new ArrayList<>(out));
        }
        helper(root.left, target-root.val);
        helper(root.right, target-root.val);
        out.remove(out.size()-1);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        List<List<Integer>> lists = pathSum(node1, 22);
        System.out.println(lists);
    }
}
