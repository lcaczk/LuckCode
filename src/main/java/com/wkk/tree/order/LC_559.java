package com.wkk.tree.order;

import com.common.structure.Node;

import java.util.Objects;

/**
 * N叉树的最大深度
 * 思路：和二叉树的最大深度思路一样
 * @author weikunkun
 * @since 2021/2/23
 */
public class LC_559 {
    public int maxDepth(Node root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int max = 0;
        if (root.children != null) {
            for(Node node : root.children) {
                max = Math.max(maxDepth(node), max);
            }
        }
        return max + 1;
    }
}
