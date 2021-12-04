package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105 从前序与中序遍历
 * @author weikunkun
 * @since 2021/3/14
 */
public class LC_105 {
    private int[] preorder;
    private int[] inorder;
    private int preStarter;
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 思路
        // 按照构造思路
        // 先用map存储中序遍历 方便每次读取 key: nums[i], value i;
        return buildTree(0, preorder.length-1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[preStarter++];
        int idx = map.get(val);
        TreeNode root = new TreeNode(val);
        root.left = buildTree(left, idx - 1);
        root.right = buildTree(idx + 1, right);
        return root;
    }
}
