package com.wkk.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-2下午3:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RecoverBinarySearchTree {
    public void revcoverTree(TreeNode root){
        List<Integer> list = new LinkedList<Integer>();
        rebuild(root, list);


    }

    private void rebuild(TreeNode root, List<Integer> list) {
        if(root!=null){
            rebuild(root.left, list);
            list.add(root.val);
            rebuild(root.right, list);
        }
    }


}
