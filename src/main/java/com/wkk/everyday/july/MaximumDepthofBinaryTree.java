package com.wkk.everyday.july;

import com.wkk.newcoder.base.tree.Tree;
import com.wkk.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time: 2020/7/28下午5:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MaximumDepthofBinaryTree {
    // 深度遍历 即 递归
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // 广度遍历 层次遍历
    public int maDepthII(TreeNode root){
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if(p.left != null){
                    queue.offer(p.left);
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
            }
            count++;
        }
        return count;
    }
}
