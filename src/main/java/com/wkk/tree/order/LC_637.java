package com.wkk.tree.order;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 637 二叉树的每一层的平均值
 *
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                sum += p.val;
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            double ave = sum / size;
            result.add(ave);
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(2147483647);
//        TreeNode node1 = new TreeNode(2147483647);
//        TreeNode node2 = new TreeNode(2147483647);
//        node.left = node1;
//        node.right = node2;
//        LC_637 lc_637 = new LC_637();
//        lc_637.averageOfLevels(node);
        long a = 2147483647L + 2147483647L;
        System.out.println(Long.MAX_VALUE);
        System.out.println(a);
    }
}
