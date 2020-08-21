package com.wkk.linkedlist;

import com.common.structure.ListNode;

/**
 * @Time: 20-3-22下午8:19
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConvertBinaryNumberInALinkedListtoInteger {
    public static int getDecimalValue(ListNode head) {
        int length = getLength(head);
        int sum =0;
        while (head != null){
            sum += head.val*Math.pow(2, length-1);
            head = head.next;
            length--;
        }
        return sum;
    }
    public static int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length ++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode node = GenLinkedList.genList();
        int decimalValue = getDecimalValue(node);
        System.out.println(decimalValue);

    }
}
