package com.wkk.everyday.june;

import com.wkk.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Time: 2020/6/16上午6:43
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SerializeandDeserializeBinaryTree {
    // 使用前序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private void preOrder(TreeNode root, StringBuilder stringBuilder) {
        if(root == null){
            stringBuilder.append("#").append(",");
            return;
        }
        stringBuilder.append(root.val).append(",");
        preOrder(root.left, stringBuilder);
        preOrder(root.right, stringBuilder);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Deque<String> list = new ArrayDeque<>(Arrays.asList(split));
        return constructTree(list);
    }
    private TreeNode constructTree(Deque<String> list){
        String s = list.pollFirst();
        if(s.equals("#")){
            return null;
        }
        int value = Integer.parseInt(s);
        TreeNode cur = new TreeNode(value);
        cur.left = constructTree(list);
        cur.right = constructTree(list);
        return cur;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        SerializeandDeserializeBinaryTree sdb = new SerializeandDeserializeBinaryTree();
        String serialize = sdb.serialize(node1);
        System.out.println(serialize);

        TreeNode deserialize = sdb.deserialize(serialize);
        System.out.println(deserialize.val);
    }
}
