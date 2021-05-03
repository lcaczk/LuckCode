package com.wkk.dfs;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 求根到叶子节点数字之和
 * @author weikunkun
 * @since 2021/5/2
 */
public class BinaryTreePathSum {
    private List<String> res = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // dfs (前序遍历)
        // sb 存储所有的路径，之后累加
        dfs(root, new StringBuilder());
        System.out.println(res);
        List<Integer> intRes = res.stream().map(Integer::parseInt).collect(Collectors.toList());
        return intRes.stream()
                .reduce(0, Integer::sum);
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            dfs(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (root.right != null) {
            dfs(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
