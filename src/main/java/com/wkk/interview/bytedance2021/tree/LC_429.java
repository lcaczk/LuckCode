package com.wkk.interview.bytedance2021.tree;

import com.common.structure.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 *  N 叉树的层序遍历
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Node p = root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (null != p.children && !p.children.isEmpty()) {
                    List<Node> children = p.children;
                    for (Node node : children) {
                        queue.offer(node);
                    }
                }
                out.add(p.val);
            }
            result.add(out);
            out = new ArrayList<>();
        }
        return result;
    }
}
