package com.common.structure;

/**
 * @Time: 20-2-24上午11:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TreeNode {
    public int val;
    public int count;
    public TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
        this.count = 0;
    }
    public TreeNode(){}
}
