package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 129 求根节点到叶节点数字之和
 *
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_129 {
    public int sumNumbers(TreeNode root) {
        // 所有的路径求出之后，获得结果
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return -1;
        }
        preOrder(root, res, new ArrayList<>());
        return genResult(res);
    }

    private void preOrder(TreeNode root, List<List<Integer>> res, List<Integer> out) {
        if (root == null) {
            return;
        }
        out.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(out));
        }
        preOrder(root.left, res, out);
        preOrder(root.right, res, out);
        out.remove(out.size() - 1);
    }

    private int genResult(List<List<Integer>> res) {
        int sum = 0;
        for (List<Integer> temp : res) {
            StringBuilder sb = new StringBuilder();
            for (int num : temp) {
                sb.append(num);
            }
            int levelNum = Integer.parseInt(sb.toString());
            sum += levelNum;
        }
        return sum;
    }
}
