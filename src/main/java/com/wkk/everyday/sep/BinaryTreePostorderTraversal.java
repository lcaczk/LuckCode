package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目: 二叉树的后序遍历
 * 链接: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author kongwiki@163.com
 * @since 2020/9/29 9:26 下午
 */
public class BinaryTreePostorderTraversal {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        helper(root);
        return res;
    }
    private void helper(TreeNode root) {
        if(root == null){
            return;
        }
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}
