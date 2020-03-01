package com.wkk.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time: 20-3-1上午8:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversa {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) {
            indexMap.put(inorder[i], i);
        }
        return build(indexMap, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(Map<Integer, Integer> indexMap, int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {
        // terminator
        if (inStart > inEnd) {
            return null;
        }
        // process
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = indexMap.get(postorder[postEnd]);
        int len = i - inStart;

        // drill down
        root.left = build(indexMap, inorder, inStart, i - 1, postorder, postStart, postStart + len - 1);
        root.right = build(indexMap, inorder, i + 1, inEnd, postorder, postStart + len, postEnd - 1);

        return root;
    }
}
