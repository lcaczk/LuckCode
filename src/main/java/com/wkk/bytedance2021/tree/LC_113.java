package com.wkk.bytedance2021.tree;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 113 路径总和II
 *
 * @author weikunkun
 * @since 2021/3/21
 */
public class LC_113 {
    /**
     * 深度遍历
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        helper(root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new ArrayList<>(tmp));
        }
        helper(root.left, sum-root.val, res, tmp);
        helper(root.right, sum-root.val, res, tmp);
        tmp.remove(tmp.size()-1);
    }

    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        //如果节点为空直接返回
        if (root == null)
            return res;
        //使用两个队列，一个存储结点，一个存储从更结点到当前节点的路径
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<List<Integer>> queueList = new LinkedList<>();
        //根节点入队
        queueNode.add(root);
        //根节点的路径入队
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        queueList.add(list);

        while (!queueNode.isEmpty()) {
            //当前节点出队
            TreeNode node = queueNode.poll();
            //当前节点的路径出队
            List<Integer> tempList = queueList.poll();
            if (node.left == null && node.right == null && node.val == sum) {
                //如果满足条件，就把路径存储到res中
                res.add(tempList);
            }
            //左子节点不为空，左子节点和路径入队
            if (node.left != null) {
                tempList.add(node.left.val);
                queueList.add(new ArrayList<>(tempList));
                node.left.val += node.val;
                queueNode.add(node.left);
                tempList.remove(tempList.size() - 1);
            }
            //右子节点不为空，右子节点和路径入队
            if (node.right != null) {
                tempList.add(node.right.val);
                queueList.add(new ArrayList<>(tempList));
                node.right.val += node.val;
                queueNode.add(node.right);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        LC_113 lc_113 = new LC_113();
        List<List<Integer>> result = lc_113.pathSum(node1, 3);
        System.out.println(result);
    }
}
