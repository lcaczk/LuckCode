package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目： 二叉树的层平均值
 * 思路： 层次遍历，注意数值类型的溢出
 * @author kongwiki@163.com
 * @since 2020/9/12 10:26 上午
 */
public class AverageOfLevelsInBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        // 使用层次遍历法
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        List<Long> out = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                out.add((long)p.val);

                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            double levelAve = average(out, size);
            out = new ArrayList<>();
            res.add(levelAve);
        }
        return res;
    }

    private static double average(List<Long> sequences, int size) {
        Long sum = 0L;
        double count = (double) size;
        for (Long num : sequences) {
            sum += num;
        }
        return sum / count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        TreeNode left = new TreeNode(2147483647);
        TreeNode right = new TreeNode(2147483647);
        root.left = left;
        root.right = right;
        List<Double> doubles = averageOfLevels(root);

    }
}
