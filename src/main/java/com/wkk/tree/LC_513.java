package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 513 树左下角的值
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_513 {
    /**
     * 层次遍历
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (Objects.isNull(root)) {
            return -1;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
        int left = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                if (i == 0) {
                    left = p.val;
                }
            }
        }
        return left;
    }


}
