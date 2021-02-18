package com.wkk.top100.tree.medium;

import com.common.structure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 把二叉搜索树转化为累加树
 * @author weikunkun
 * @since 2021/2/18
 */
public class LC_538 {
    private int number = 0;
    public TreeNode convertBST(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }
        // 右 根 左
        rightAndLeftOrder(root);
        System.out.println();
        return root;
    }

    private void rightAndLeftOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        rightAndLeftOrder(root.right);
        number += root.val;
        root.val = number;
        rightAndLeftOrder(root.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        node7.right = node9;
        LC_538 lc_538 = new LC_538();
        lc_538.convertBST(node1);
        Map<String, List<String>> map = new HashMap<>(16);
        String s = "abcdefg";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
}
