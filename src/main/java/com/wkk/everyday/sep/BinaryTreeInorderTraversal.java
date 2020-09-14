package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author kongwiki@163.com
 * @since 2020/9/14 7:51 下午
 */
public class BinaryTreeInorderTraversal {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.poll();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}
