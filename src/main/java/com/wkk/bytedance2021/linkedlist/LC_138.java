package com.wkk.bytedance2021.linkedlist;

import com.common.structure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138 复制带随机指针的链表
 * @author weikunkun
 * @since 2021/3/26
 */
public class LC_138 {
    public Node copyRandomList(Node head) {
        // 思路 先复制next
        // 后复制 random
        // map 存储 key: 旧节点  value: 新节点
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node oHead = head;
        Node nHead = new Node(head.val);
        Node flag = nHead;
        map.put(oHead, nHead);
        // 注意截止条件
        while (oHead.next != null) {
            oHead = oHead.next;
            nHead.next = new Node(oHead.val);
            nHead = nHead.next;
            map.put(oHead, nHead);
        }
        oHead = head;
        nHead = flag;
        while (oHead != null) {
            if (oHead.random != null) {
                Node node = map.get(oHead.random);
                nHead.random = node;
            }
            oHead = oHead.next;
            nHead = nHead.next;
        }
        return flag;
    }
}
