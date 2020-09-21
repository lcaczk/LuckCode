package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.*;

/**
 * 题目：538.把二叉搜索树转换为累加树
 * 题目链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * <p>
 * 题目描述：
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
 * 点值之和。
 * <p>
 * 示例：
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 *
 *
 *
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
 * 相同
 * <p>
 * 思路：时间关系，并没有考虑BST的特性，直接使用层次+其他随便的遍历方式解决。
 *
 * @author kongwiki@163.com
 * @since 2020/9/21 8:08 下午
 */
public class ConvertBST2GreaterTree {
    private List<Integer> res = null;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        res = tree2List(root);
        TreeNode p = root;
        queue.offer(p);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                p = queue.poll();
                p.val += sum(res, p.val);
                if(p.left != null){
                    queue.offer(p.left);
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
            }
        }
        return root;
    }

    private List<Integer> tree2List(TreeNode root){
        // 中序遍历
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if(p != null) {
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }


    private int sum(List<Integer> res, int target){
        int sum = 0;
        for(Integer r : res){
            if(r > target) {
                sum += r;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        ConvertBST2GreaterTree tree = new ConvertBST2GreaterTree();
        tree.convertBST(node1);
    }
}
