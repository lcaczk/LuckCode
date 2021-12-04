package com.wkk.interview.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/4/21
 */
public class LC_993 {
    private Map<Integer, Integer> depth; // 记录深度
    private Map<Integer, TreeNode> path; // 记录父节点
    TreeNode pre = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        depth = new HashMap<Integer, Integer>();
        path = new HashMap<Integer, TreeNode>();
        preOrder(root);
        return depth.get(x) == depth.get(y) && path.get(x) == path.get(y);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        depth.put(root.val, pre != null ? 1 + depth.get(pre.val) : 0);
        path.put(root.val, pre);
        pre = root;
        preOrder(root.left);
        preOrder(root.right);
    }
}
