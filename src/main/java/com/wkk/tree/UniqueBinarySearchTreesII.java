package com.wkk.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-2-29下午8:42
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
         if(n == 0){
             return new LinkedList<TreeNode>();
         }
        return  helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(start > end){
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            for (TreeNode nodeL : left) {
                for (TreeNode nodeR : right) {
                    TreeNode iNode = new TreeNode(i);
                    iNode.left = nodeL;
                    iNode.right = nodeR;
                    res.add(iNode);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 2;
        UniqueBinarySearchTreesII trees = new UniqueBinarySearchTreesII();
        List<TreeNode> nums = trees.generateTrees(n);
        System.out.println(nums);
    }
}
