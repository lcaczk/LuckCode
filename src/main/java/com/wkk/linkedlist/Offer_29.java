package com.wkk.linkedlist;


import com.common.structure.Node;

/**
 * @author weikunkun
 * @since 2021/8/16
 */
public class Offer_29 {
    public static Node insert(Node head, int insertVal) {
        if (head == null) {
            Node tmp = new Node(insertVal);
            tmp.next = tmp;
            return tmp;
        }

        Node cur = head;
        Node pre = head;
        boolean flag = false;
        while (cur.next != null && cur.next.val != head.val) {
            if (pre.val < insertVal && cur.val > insertVal) {
                Node tmp = new Node(insertVal);
                tmp.next = pre.next;
                pre.next = tmp;
                flag = true;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (!flag) {
            Node tmp = new Node(insertVal);
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node node1 = new Node(4);
        Node node2 = new Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = head;
        insert(head,2);
    }
}
