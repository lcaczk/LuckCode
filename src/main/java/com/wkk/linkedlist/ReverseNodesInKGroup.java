package com.wkk.linkedlist;

/**
 * @Time: 20-2-23上午10:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReverseNodesInKGroup {
    // 给定k值 将k个节点之间进行交换
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while(true){
            int count = 0;
            while(tail!=null && count < k){
                count++;
                tail = tail.next;
            }
            if(tail == null){
                break;
            }
            // 使用尾插方法
            //  pre
            //
            // dummy  1  2  3  4  5
            //       cur   tail
            // 尾插之前做标志位 防止断链
            ListNode flag = pre.next;
            while(pre.next != tail){
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            pre = flag;
            tail = pre;
        }
        return dummy.next;
    }


    // 给定k值 将前k个节点进行交换
    public static ListNode reverseKGroupII(ListNode head, int k) {
        ListNode stop = head;
        for (int i = 0; i < k; i++) {
            stop = stop.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (k != 0) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
            k--;
        }
        ListNode tail = dummy.next;
        for (int i = 0; i < 3; i++) {
            tail = tail.next;
        }
        tail.next = stop;


        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = ConstructNode.testNode();
        ListNode node1 = ReverseNodesInKGroup.reverseKGroup(node, 3);
        System.out.println(node1.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.next.next.val);
        System.out.println(node1.next.next.next.next.val);

    }
}
