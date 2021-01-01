package com.wkk.newcoder.book.linkedlist;

import com.common.structure.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongwiki@163.com
 * @since 2021/1/1
 */
public class ReversePartNodeTest {
    @Test
    public void getTargetNodeTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Assert.assertEquals(ReversePartNode.getTargetNode(node1, 2), node2);
        Assert.assertEquals(ReversePartNode.getTargetNode(node1, 3), node3);
        Assert.assertEquals(ReversePartNode.getTargetNode(node1, 4), node4);
    }

    @Test
    public void reversePartTest() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Assert.assertEquals(ReversePartNode.reversePart(node1, 2, 4).next, node4);
    }
}