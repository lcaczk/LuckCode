package com.wkk.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-2-29下午9:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        TreeNode node = new TreeNode();
        while (root != null) {
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


}
