package com.wkk.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * @Time: 20-2-25上午10:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinarySearchTreeIterator {
    private Iterator<Integer> iterator;
    public BinarySearchTreeIterator(TreeNode root) {
        List list = new ArrayList<Integer>();
        inOrder(root, list);
        iterator = list.iterator();

    }
    private void inOrder(TreeNode root, List list){
        if(list !=null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
