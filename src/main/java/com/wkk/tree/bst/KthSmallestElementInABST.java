package com.wkk.tree.bst;

import com.common.structure.TreeNode;

import java.util.Stack;

/**
 * @Time: 20-3-6上午9:03
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class KthSmallestElementInABST {
    public static int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                count ++;
                if(count == k){
                    return p.val;
                }
                p = p.right;

            }
        }
        return 0;

    }

    private static void inOrder(TreeNode root, int count, int k, Stack<Integer> stack, int kSmal) {
        count++;
        if (root != null) {
            stack.push(root.val);
            inOrder(root.left, count, k, stack, kSmal);
            if (count == k) {
                Integer pop = stack.pop();
                kSmal = pop;
            }
            inOrder(root.right, count, k, stack, kSmal);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;

        int i = KthSmallestElementInABST.kthSmallest(node2, 1);
        System.out.println(i);

    }
}
