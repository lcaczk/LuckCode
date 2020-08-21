package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-4下午6:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        List<Integer> out = new LinkedList<Integer>();
        dfs(root, sum, results, out);
        return results;
    }

    private static void dfs(TreeNode root, int sum, List<List<Integer>> results, List<Integer> out) {
        if (root == null) {
            return;
        }
        out.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            results.add(new LinkedList<Integer>(out));
        }
        dfs(root.left, sum - root.val, results, out);
        dfs(root.right, sum - root.val, results, out);
        out.remove(out.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(4);


        node1.left = node2;
        node1.right = node3;
        node3.left = node4;


        List<List<Integer>> lists = pathSum(node1, 13);
        System.out.println(lists);

    }
}
