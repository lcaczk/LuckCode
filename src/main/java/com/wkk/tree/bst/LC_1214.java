package com.wkk.tree.bst;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/3/11
 */
public class LC_1214 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(Objects.isNull(root1) || Objects.isNull(root2)) {
            return false;
        }
        // 思路：通过遍历，获取树A的每一个节点，之后再使用遍历获取树B的每一个节点
        // 时间复杂度 O(NlogN)
        // 空间复杂度 O(n)
        TreeNode first = root1;
        TreeNode second = root2;
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(first);
        while (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                first = queue1.poll();
                int diff = target - first.val;
                if (findSum(second, diff)) {
                    return true;
                }
                if (Objects.nonNull(first.left)) {
                    queue1.offer(first.left);
                }
                if (Objects.nonNull(first.right)) {
                    queue1.offer(first.right);
                }
            }
        }
        return false;
    }

    private boolean findSum(TreeNode root, int number) {
        // 在二叉搜索树上寻找一个值
        // 非递归方式，利用二叉搜索树的性质
        while (Objects.nonNull(root)) {
            if (root.val < number) {
                root = root.right;
            } else if (root.val > number) {
                root = root.left;
            } else {
                return true;
            }
        }
        return false;
    }
}
