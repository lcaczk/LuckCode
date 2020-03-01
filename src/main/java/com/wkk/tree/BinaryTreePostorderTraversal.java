package com.wkk.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-2-29下午9:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return null;
        }
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode root, List list) {
        if(root != null){
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }
    }
}
