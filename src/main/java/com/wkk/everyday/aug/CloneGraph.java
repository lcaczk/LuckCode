package com.wkk.everyday.aug;
import com.wkk.graph.Node;

import java.util.*;

/**
 * 克隆图 类似于复杂链表的复制
 * <p> 使用一个Map做映射即可
 * @author kongwiki@163.com
 * @since 2020/8/12上午8:58
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Node p = node;
        queue.offer(p);
        Node flag = null;
        Map<Node, Boolean> map = new HashMap<>();
        while(!queue.isEmpty()){
            p = queue.poll();
            map.put(p, true);
            Node newNode = new Node(p.val, new ArrayList<>());
            if(newNode.val == node.val){
                flag = newNode;
            }
            for(Node neiNode : p.neighbors){
                newNode.neighbors.add(new Node(neiNode.val, new ArrayList<>()));
                if(!map.getOrDefault(neiNode, false)){
                    queue.add(neiNode);
                }
            }
        }
        return flag;
    }

    public Node cloneGraphII(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Node p = node;
        queue.offer(p);
        Node clone = new Node(p.val, new ArrayList<>());
        Map<Node, Node> map = new HashMap<>();
        map.put(p, clone);
        while(!queue.isEmpty()){
            p = queue.poll();
            for(Node neiNode : p.neighbors){
                if(!map.containsKey(neiNode)){
                    map.put(neiNode, new Node(neiNode.val, new ArrayList<>()));
                    queue.offer(neiNode);
                }
                map.get(p).neighbors.add(map.get(neiNode));
            }
        }
        return clone;
    }
}
