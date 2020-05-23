package com.wkk.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Time: 2020/5/22下午4:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Test {
    private static final String emptyNode = "null";

    public static void main(String[] args) {
        String data = "1,2,null,null,3,null,null";
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        TreeNode constract = constract(nodes);
        System.out.println(constract.left.val);
        System.out.println(constract.right.val);

    }

    public static TreeNode constract(Deque<String> nodes) {
        String node = nodes.pollFirst();
        if (node.equalsIgnoreCase(emptyNode)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = constract(nodes);
        root.right = constract(nodes);
        return root;
    }
}
