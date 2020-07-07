package com.wkk.everyday.july;

import com.wkk.tree.TreeNode;

/**
 * @Time: 2020/7/7上午8:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return core(root, sum);
    }
    private boolean core(TreeNode cur, int sum){
        if(cur == null){
            return false;
        }
        if(cur.left == null && cur.right == null && sum==cur.val){
            return true;
        }
        return core(cur.left, sum-cur.val) || core(cur.right, sum-cur.val);

    }
}
