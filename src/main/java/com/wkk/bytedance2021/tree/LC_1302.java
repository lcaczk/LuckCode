package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * 层次遍历： 每一层都统计总和，然后覆盖，最后的结果及为最后一层的结果
 * @author weikunkun
 * @since 2021/4/16
 */
public class LC_1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            while (size-- > 0) {
                p = queue.poll();
                sum += p.val;
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return sum;
    }
}
