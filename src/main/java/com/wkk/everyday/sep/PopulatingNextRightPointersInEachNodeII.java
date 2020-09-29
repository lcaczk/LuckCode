package com.wkk.everyday.sep;

import com.wkk.graph.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目：填充每个节点的下一个右侧节点指针 II
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 思路： 层次遍历+辅助指针
 * @author kongwiki@163.com
 * @since 2020/9/28 8:04 下午
 */
public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        Node p = root;
        queue.offer(p);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node left = null;
            for(int i = 1; i <= size; i++) {
                p = queue.poll();
                if(p.left != null){
                    queue.offer(p.left);
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
                if(i != 1){
                    left.next = p;
                }
                left = p;
//                if(i == 1){
//                    left = p;
//                }else {
//                    left.next = p;
//                    left = p;
//                }
            }
        }
        return root;
    }
}
