package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/5/17
 */
public class LC_993 {
    private TreeNode firstPre;
    private TreeNode secondPre;

    private Map<Integer, Integer> depth; // 记录深度
    private Map<Integer, TreeNode> path; // 记录父节点

    public boolean isCousins(TreeNode root, int x, int y) {
        // 使用层次遍历，同时设置两个pre来标记对应节点的pre
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.left != null) {
                    if (p.left.val == x) {
                        firstPre = p;
                    }
                    if (p.left.val == y) {
                        secondPre = p;
                    }
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    if (p.right.val == x) {
                        firstPre = p;
                    } else if (p.right.val == y) {
                        secondPre = p;
                    }
                    queue.offer(p.right);
                }
            }
            // 遍历完一层
            if (firstPre != null && secondPre != null) {
                return firstPre != secondPre;
            }
            // 重置标识位
            firstPre = null;
            secondPre = null;
        }
        return false;
    }

    /**
     * 使用前序遍历
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousinsII(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        depth = new HashMap<>();
        path = new HashMap<>();
        preOrder(root, null);
        return depth.get(x) == depth.get(y) && path.get(x) != path.get(y);
    }

    private void preOrder(TreeNode root, TreeNode pre) {
        if (root == null) {
            return;
        }
        depth.put(root.val, pre != null ? 1 + depth.get(pre.val) : 0);
        path.put(root.val, pre);
        preOrder(root.left, root);
        preOrder(root.right, root);
    }

    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Map<Integer, Integer> depths = new HashMap<>();
    public boolean isCousinsIII(TreeNode root, int x, int y) {
        // 需要存储 每个节点的深度， 每个节点的父节点
        dfs(root, null, 0);
        return depths.get(x) == depths.get(y) && parent.get(x).val != parent.get(y).val;
    }

    private void dfs(TreeNode root, TreeNode pre, int level) {
        if (root == null) {
            return;
        }
        parent.put(root.val, pre);
        depths.put(root.val, level);
        dfs(root.left, root, level + 1);
        dfs(root.right, root, level + 1);
    }

    private static int[] genRemovedArray(int[] array, int idx) {
        int len = array.length;
        int[] res = new int[len - 1];
        int numMoved = len - idx - 1;
        System.arraycopy(array, 0, res, 0, idx);
        System.arraycopy(array, idx + 1, res, idx, numMoved);
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] ints = genRemovedArray(array, 0);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
