package com.wkk.tree;


import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-1下午9:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        if (root == null) {
            return list;
        }
        paths(root, "", list);
        return list;
    }

    private void paths(TreeNode root, String out, List<String> list) {
        if(root.left == null && root.right == null){
            list.add(out + root.val);
        }
        if (root.left != null){
            paths(root.left, out + root.val + "->", list);
        }
        if(root.right != null){
            paths(root.right, out+root.val + "->", list);
        }

    }
}
