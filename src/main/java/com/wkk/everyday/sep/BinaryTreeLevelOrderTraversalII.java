package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：二叉树的层次遍历
 * <p>
 * 描述：给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 思路：层次遍历，然后利用list的插入特性，在指定位置插入即可
 * @author kongwiki@163.com
 * @since 2020/9/6 3:02 下午
 */
public class BinaryTreeLevelOrderTraversalII {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> out = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return res;
        }
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                p = queue.poll();
                out.add(p.val);
                if(p.left != null){
                    queue.offer(p.left);
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
            }
            res.add(0, out);
            out = new ArrayList<>();
        }
        return res;
    }
}
