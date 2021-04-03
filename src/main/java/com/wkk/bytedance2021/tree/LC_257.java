package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        if (Objects.isNull(root)) {
            return result;
        }
        backtrack(root, result, deque);
        return result;
    }

    /**
     * 包含有回溯的前序遍历
     * @param root
     * @param result
     * @param deque
     */
    private void backtrack(TreeNode root, List<String> result, Deque<Integer> deque) {
        deque.addLast(root.val);
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            StringBuilder sb = new StringBuilder();
            // 不能将队列中的元素弹出，会导致递归回上一层的时候，deque已经没有数据，进而使得回溯无法进行
            for (Integer item : deque) {
                sb.append(item).append("->");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        if (!Objects.isNull(root.left)) {
            backtrack(root.left, result, deque);
            deque.removeLast();
        }

        if (!Objects.isNull(root.right)) {
            backtrack(root.right, result, deque);
            deque.removeLast();
        }
    }
}
