package com.wkk.tree.order;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 222 完全二叉树的节点个数
 * 思路：广度遍历/深度遍历
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_222 {
    /**
     * 深度遍历
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    /**
     * 广度遍历
     * @param root
     * @return
     */
    public int countNodesII(TreeNode root) {
        int count = 0;
        if (Objects.isNull(root)) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                count++;
                p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }

            }
        }
        return count;
    }
}
