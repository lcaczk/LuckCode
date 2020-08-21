package com.wkk.newcoder.base.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 2020/6/29下午12:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Order {
    // ***************************************************
    // ****************树的遍历系列***********************
    // ***************************************************
    public static void order(TreeNode node){
        if(node == null){
            return;
        }
        // 1
        System.out.print(node.val + " ");
        order(node.left);
        // 2
        System.out.print(node.val + " ");
        order(node.right);
        // 3
        System.out.print(node.val + " ");
    }
    // 先序遍历
    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void preOrderII(TreeNode node){
        if(node == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = node;
        while (!stack.isEmpty() || p != null){
            while (p != null){
                // do something
                System.out.print(p.val + " ");
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                p = p.right;
            }
        }
    }
    public static void preOrderIII(TreeNode node){
        if(node == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(node);
        TreeNode p;
        while (!stack.isEmpty()){
            p = stack.pop();
            System.out.print(p.val + " ");
            if(p.right != null){
                stack.push(p.right);
            }
            if(p.left != null){
                stack.push(p.left);
            }
        }
        System.out.println();
    }
    // 中序遍历
    public static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }
    public static void inOrderII(TreeNode node){
        if(node == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = node;
        while (!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                System.out.println(p.val + " ");
                p = p.right;
            }
        }
    }
    // 后续遍历
    public static void postOrder(TreeNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
    public static void postOrderII(TreeNode node){
        if(node == null){
            return;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(node);
        TreeNode p;
        while (!stack1.isEmpty()){
            p = stack1.pop();
            stack2.push(p);
            if(p.left != null){
                stack1.push(p.left);
            }
            if(p.right != null){
                stack1.push(p.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.poll().val + " ");
        }
        System.out.println();
    }
}
