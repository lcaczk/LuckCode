package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_106 {
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
}
