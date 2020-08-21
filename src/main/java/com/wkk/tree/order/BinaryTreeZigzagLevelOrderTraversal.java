package com.wkk.tree.order;

import com.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Time: 20-3-4下午5:33
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 1;
        if(root == null){
            return results;
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> out = new LinkedList<Integer>();
            for (int i = size; i >0; i--) {
                TreeNode p = queue.poll();
                if(level%2 == 0){
                    out.add(0, p.val);
                }else if(level%2 == 1){
                    out.add(p.val);
                }
                if(p.left != null){
                    queue.add(p.left);
                }
                if(p.right != null){
                    queue.add(p.right);
                }
            }
            level ++;
            results.add(out);
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        List<List<Integer>> lists = zigzagLevelOrder(node1);
        System.out.println(lists);
    }
}
