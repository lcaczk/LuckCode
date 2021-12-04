package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Time: 20-3-6下午5:58
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SerializeAndDeserializeBinaryTree {
    private String SPLIT = ",";
    private String EMPTY = "#";
    private StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 前序遍历
        if (root == null) {
            return EMPTY;
        }
        serialized(root);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void serialized(TreeNode root) {
        if (root == null) {
            sb.append(EMPTY);
            sb.append(SPLIT);
            return;
        }
        sb.append(root.val);
        sb.append(SPLIT);
        serialized(root.left);
        serialized(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(SPLIT);
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(arr));
        return deserialize(queue);
    }

    private TreeNode deserialize(Deque<String> queue) {
        if (queue.isEmpty()) { // 1
            return null;
        }
        String str = queue.poll();
        // 1、2 不能够合并，不然 队列元素无法正常弹出，导致后续元素一直无法构成
        if (str.equals(EMPTY)) { // 2
            return null;
        }
        int val = Integer.parseInt(str);
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
