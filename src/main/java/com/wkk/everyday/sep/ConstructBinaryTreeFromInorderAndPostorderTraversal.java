package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：从中序和后序遍历序列构造二叉树
 * 连接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 思路：和剑指offer第7题同理，但是编写的更加清晰了
 * @author kongwiki@163.com
 * @since 2020/9/25 10:22 下午
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private static int[] inOrder, postOrder;
    private static Map<Integer, Integer> map = new HashMap<>(16);
    private static int postStarter;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        postStarter = postorder.length-1;
        for(int i = 0; i < inOrder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(0, inOrder.length-1);
    }

    private static TreeNode helper(int left, int right){
        if(left > right){
            return null;
        }
        // 从中间隔开，分为左右两个数组构建左右子树
        int val = postOrder[postStarter];
        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        postStarter--;
        root.right = helper(idx+1, right);
        root.left = helper(left, idx-1);
        return root;

    }

    public static void main(String[] args) {
        int[] post = {9, 15, 7, 20 ,3};
        int[] in = {9 , 3, 15, 20, 7};
        buildTree(in, post);
    }
}
