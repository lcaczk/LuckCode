package com.wkk.everyday.sep;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：404. 左叶子之和
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves/
 * <p>
 * 示例：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 思路：题目看清楚，层次遍历衍生问题
 *
 * @author kongwiki@163.com
 * @since 2020/9/19 11:31 下午
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                    if (p.left.left == null && p.left.right == null) {
                        res.add(p.left.val);
                    }
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }

        }
        return sum(res);

    }

    private int sum(List<Integer> res) {
        int sum = 0;
        for (Integer r : res) {
            sum += r;
        }
        return sum;
    }
}
