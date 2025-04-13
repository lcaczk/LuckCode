package com.wkk.simulation.lc;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * @author weikunkun
 * @since 2021/12/5
 */
public class LC_5944 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // 思路
        // 寻找公共父节点
        // 父节点到对应节点的路径
        // 路径 求反
        // 组合
        TreeNode p = new TreeNode(startValue);
        TreeNode q = new TreeNode(destValue);
        TreeNode common = lowestCommonAncestor(root, p, q);
        return "";

    }

    public List<String> binaryTreePaths(TreeNode root, TreeNode target) {
        List<String> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        if (Objects.isNull(root)) {
            return result;
        }
        backtrack(root, result, deque, target);
        return result;
    }

    private void backtrack(TreeNode root, List<String> result, Deque<Integer> deque, TreeNode target) {
        // 先添加元素，否则会导致叶子节点无法入队列
        deque.addLast(root.val);
        if (root.val == target.val) {
            StringBuilder sb = new StringBuilder();
            // 不能将队列中的元素弹出，会导致递归回上一层的时候，deque已经没有数据，进而使得回溯无法进行
            for (Integer item : deque) {
                sb.append(item).append("->");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        if (!Objects.isNull(root.left)) {
            backtrack(root.left, result, deque, target);
            deque.removeLast();
        }

        if (!Objects.isNull(root.right)) {
            backtrack(root.right, result, deque, target);
            deque.removeLast();
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == root.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else if (left == null && right == null) {
            return null;
        }
        return root;
    }
}
