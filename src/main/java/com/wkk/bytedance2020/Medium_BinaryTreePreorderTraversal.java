package com.wkk.bytedance2020;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Time: 2020/7/20下午12:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }
            else {
                p = stack.pop();
                p = p.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
