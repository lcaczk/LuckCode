package com.wkk.tree.order;

import com.common.structure.Node;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_116 {
    public Node connect(Node root) {
        if (Objects.isNull(root)) {
            return root;
        }
        Node p = root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(p);
        Node pre = root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                // 尾边界不处理
//                if (i == size-1) {
//                    p.next = null;
//                }else if (i == 0) {
//                    pre = p;
//                }
//                if (pre != p) {
//                    pre.next = p;
//                    pre = p;
//                }
                // 优化
                // 每一层的尾节点不用处理
                if (i < size - 1) {
                    p.next = queue.peek();
                }

                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return root;
    }
}
