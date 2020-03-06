package com.wkk.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time: 20-3-5下午9:47
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node p = queue.poll();
                if(i == size-1){
                    p.next = null;
                }
                else {
                    p.next = queue.peek();
                }
                if(p.left !=null){
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
