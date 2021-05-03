package com.wkk.recursive.base;

import com.common.structure.ListNode;

/**
 * @author weikunkun
 * @since 2021/5/1
 */
public class ReverseNode {
//    我们可以定义函数swap(head)以实现解决方案，其中输入的参数head指向链表的头节点。而该函数应当返回将链表中每两个相邻节点交换后得到的新列表的头节点head。
//
//    按照我们上面列出的步骤，我们可以按下面的流程来实现函数：
//
//    首先，我们交换列表中的前两个节点，也就是head和head.next；
//    然后我们以swap(head.next.next)的形式调用函数自身，以交换头两个节点之后列表的其余部分。
//    最后，我们将步骤（2）中的子列表的返回头与步骤（1）中交换的两个节点相连，以形成新的链表。


    public ListNode swapPairs(ListNode head) {
        // 递归
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        reverse(pre, head);
        return dummy.next;
    }

    private void reverse(ListNode pre, ListNode cur) {
        if (cur == null || cur.next == null) {
            return;
        }
        ListNode next = cur.next;
        cur.next = next.next;
        next.next = cur;
        pre.next = next;
        reverse(cur, cur.next);
    }
}
