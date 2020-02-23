package com.wkk.linkedlist;

/**
 * @Time: 20-2-22下午5:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode head){
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head!=null && head.next!=null){
            pre.next = head.next;
            head.next = pre.next.next;
            pre.next.next = head;
            pre = pre.next.next;
            head = pre.next;
        }
        return dummy.next;

//        ListNode list1=new ListNode(0);
//        list1.next=head;
//        ListNode list2=list1;
//        while(head!=null&&head.next!=null){
//            list2.next=head.next;
//            head.next=list2.next.next;
//            list2.next.next=head;
//            list2=list2.next.next;
//            head=list2.next;
//        }


    }

    public static void main(String[] args) {
        ListNode node = ConstructNode.testNode();
        ListNode node1 = swapPairs(node);
        System.out.println(node1.val);
        System.out.println(node1.next.val);
        System.out.println(node1.next.next.val);
        System.out.println(node1.next.next.next.val);
    }
}
