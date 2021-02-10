package com.wkk.top100.tree;

import com.common.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/2/6
 */
public class LC_105 {
    private static int[] inOrder, preOrder;
    private static final Map<Integer, Integer> map = new HashMap<>(16);
    private static int preStarter;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        preStarter = 0;
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, inOrder.length - 1);
    }

    private static TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        // 从中间隔开，分为左右两个数组构建左右子树
        int val = preOrder[preStarter];
        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        preStarter++;
        root.left = helper(left, idx - 1);
        root.right = helper(idx + 1, right);
        return root;
    }

}
