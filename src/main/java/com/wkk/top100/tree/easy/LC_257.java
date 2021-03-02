package com.wkk.top100.tree.easy;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * 257 二叉树的所有路径
 * @author weikunkun
 * @since 2021/3/1
 */
public class LC_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        if (Objects.isNull(root)) {
            return result;
        }
        backtrack(root, result, deque);
        return result;
    }

    /**
     * 包含有回溯的前序遍历
     * @param root
     * @param result
     * @param deque
     */
    private void backtrack(TreeNode root, List<String> result, Deque<Integer> deque) {
        deque.addLast(root.val);
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
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
            backtrack(root.left, result, deque);
            deque.removeLast();
        }

        if (!Objects.isNull(root.right)) {
            backtrack(root.right, result, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        LC_257 lc_257 = new LC_257();
        lc_257.binaryTreePaths(node1);
    }
}
