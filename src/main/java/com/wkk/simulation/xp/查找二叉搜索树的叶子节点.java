package com.wkk.simulation.xp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/6/26
 */
public class 查找二叉搜索树的叶子节点 {
    private static int[] preOrder;
    private static int[] inOrder;
    private static int starter = 0;
    private static Map<Integer, Integer> map;
    private static List<Integer> ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 按照最直白的思路来
        // 根据前中遍历构建二叉树，然后使用任何一种遍历方式获取叶子节点
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        List<Integer> inOrder = list.stream().sorted().collect(Collectors.toList());
        TreeNode root = buildeTree(list, inOrder);
        postOrder(root);
        for (Integer num : ans) {
            System.out.print(num + " ");
        }
    }

    private static TreeNode buildeTree(List<Integer> pre, List<Integer> in) {
        preOrder = pre.stream().mapToInt(i-> i).toArray();
        inOrder = in.stream().mapToInt(i -> i).toArray();
        ans = new ArrayList<>();
        map = new HashMap<>();
        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            map.put(inOrder[i], i);
        }
        return buildeTree(0, n - 1);
    }

    private static TreeNode buildeTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preOrder[starter++];
        int idx = map.get(val);
        TreeNode root = new TreeNode(val);
        root.left = buildeTree(left, idx - 1);
        root.right = buildeTree(idx + 1, right);
        return root;
    }

    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }
    }

    public static class TreeNode {
        public int val;
        public int count;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
            this.count = 0;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
