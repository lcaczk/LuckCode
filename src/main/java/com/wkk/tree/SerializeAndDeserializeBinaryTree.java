package com.wkk.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Time: 20-3-6下午5:58
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SerializeAndDeserializeBinaryTree {
    private final String delimiter = ",";
    private final String emptyNode = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(emptyNode).append(delimiter);
        } else {
            sb.append(root.val).append(delimiter);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(delimiter)));
        return deserialize(nodes);
    }

    private TreeNode deserialize(Deque<String> nodes) {
        String nodeVal = nodes.pollFirst();
        if(nodeVal.equals(emptyNode)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
            node.left = deserialize(nodes);
            node.right = deserialize(nodes);
            return node;
        }
    }
}
