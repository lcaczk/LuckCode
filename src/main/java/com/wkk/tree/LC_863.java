package com.wkk.tree;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/7/28
 */
public class LC_863 {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 构成图
        dfs(root);
        int p = target.val;
        boolean[] visited = new boolean[1000];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(p);
        visited[p] = true;
        List<Integer> ans = new LinkedList<>();
        while(!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                p = queue.poll();
                if (k == 0) {
                    ans.add(p);
                    continue;
                }
                List<Integer> tmp = map.getOrDefault(p, new ArrayList<>());
                for (int num : tmp) {
                    if (!visited[num]) {
                        queue.offer(num);
                        visited[num] = true;
                    }
                }
            }
            k--;
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.computeIfAbsent(root.val, list -> new ArrayList<>()).add(root.left.val);
            map.computeIfAbsent(root.left.val, list -> new ArrayList<>()).add(root.val);
        }
        if (root.right != null) {
            map.computeIfAbsent(root.val, list -> new ArrayList<>()).add(root.right.val);
            map.computeIfAbsent(root.right.val, list -> new ArrayList<>()).add(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        LC_863 lc_863 = new LC_863();
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(6);
//        TreeNode node5 = new TreeNode(2);
//        TreeNode node6 = new TreeNode(0);
//        TreeNode node7 = new TreeNode(8);
//        TreeNode node8 = new TreeNode(7);
//        TreeNode node9 = new TreeNode(4);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.left = node8;
//        node5.right = node9;
        TreeNode node1 = new TreeNode(1);

        lc_863.distanceK(node1, node1, 3);
    }
}
