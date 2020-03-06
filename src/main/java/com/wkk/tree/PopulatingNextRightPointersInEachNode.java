package com.wkk.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Time: 20-3-5下午9:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int currSize  = queue.size();
            for (int i = 0; i < currSize; i++) {
                Node p = queue.poll();
                if(i == currSize-1){
                    p.next = null;
                }
                else {
                    p.next  = queue.peek();
                }

                if(p.left != null){
                    queue.offer(p.left);
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
            }
        }
        return root;
    }
}
