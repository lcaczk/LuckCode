package com.wkk.recursive;

import com.common.structure.TreeNode;

/**
 * @Time: 2020/6/25下午4:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LongestUnivaluePath {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        recursive(root);
        return ans;
    }

    private int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursive(root.left);
        int right = recursive(root.right);
        int arrLeft = 0, arrRight = 0;
        if(root.left != null && root.val == root.left.val){
            arrLeft += left+1;
        }

        if(root.right != null && root.val == root.right.val){
            arrRight += right+1;
        }

        ans = Math.max(ans, arrLeft+arrRight);
        return Math.max(arrLeft, arrRight);
    }
}
