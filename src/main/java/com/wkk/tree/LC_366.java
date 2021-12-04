package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/5
 */
public class LC_366 {
    // 使用dfs，递归时传入上一个节点，如果当前节点是叶子节点，
    // 则将值加入集合，使用上个节点将当前叶子节点删除。每递归一次就会修剪掉叶子节点，形成新树，循环修剪叶子节点，直至只剩下根节点，最后将根节点加入结果集即可。
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return res;
        }
        while (root.left != null || root.right != null) {
            dfs(root, null);
            res.add(tmp);
            tmp = new ArrayList<>();
        }
        tmp.add(root.val);
        res.add(tmp);
        return res;
    }

    private void dfs(TreeNode root, TreeNode pre) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            tmp.add(root.val);
            if (pre != null && pre.left == root) {
                pre.left = null;
            } else if (pre != null && pre.right == root) {
                pre.right = null;
            }
        }
        dfs(root.left, root);
        dfs(root.right, root);
    }
}
