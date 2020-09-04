package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kongwiki@163.com
 * @since 2020/9/4 7:36 下午
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, "", root);
        return res;
    }

//    private static void dfsII(List<String> res, StringBuilder sb, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        if (root.left == null && root.right == null) {
//            res.add(sb.append(root.val).toString());
//            return;
//        }
//        sb.append(root.val + "->");
//        dfsII(res, sb, root.left);
//        dfsII(res, sb, root.right);
//    }

    private static void dfs(List<String> res, String sb, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点
            res.add(sb + root.val);
            return;
        }
        String temp = sb + root.val + "->";
        dfs(res, temp, root.left);
        dfs(res, temp, root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;

        List<String> strings = binaryTreePaths(node1);
        System.out.println(strings);
    }
}
