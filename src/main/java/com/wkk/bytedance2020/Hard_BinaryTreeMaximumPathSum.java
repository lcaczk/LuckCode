package com.wkk.bytedance2020;

import com.wkk.tree.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Time: 2020/7/20上午11:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Hard_BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        int val = root.val + left + right;
        max = Math.max(val, max);
        return Math.max(left, right) + root.val;
    }



    private List<Integer> preOrder(TreeNode node){
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode p = node;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                p = p.right;
            }
        }
        return list;
    }
}
