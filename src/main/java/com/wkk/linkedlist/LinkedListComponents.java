package com.wkk.linkedlist;

import com.common.structure.ListNode;

import java.util.*;

/**
 * @Time: 20-3-22下午3:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LinkedListComponents {
    public static int numComponents(ListNode head, int[] G) {
        // 题目理解错误
        int count = 0;
        List< List<Integer>> list = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        dfs(0, 2, G, list, out);
        for (int i = 0; i < list.size(); i++) {
            ListNode node1 = getNode(list.get(i).get(0), head);
            ListNode node2 = getNode(list.get(i).get(1), head);
            if(node1.next == node2){
                count ++;
            }
        }
        return count;


    }

    public static ListNode getNode(int val, ListNode head){
        while (head != null){
            if(head.val == val){
                return head;
            }
            else {
                head = head.next;
            }
        }
        return null;
    }

    public static void dfs(int star, int k, int[] G, List<List<Integer>> lists, List<Integer> out){
        if(out.size() == k){
            lists.add(new LinkedList<>(out));
            return;
        }
        for (int i = star; i <G.length; i++) {
            out.add(G[i]);
            dfs(i+1, k, G, lists, out);
            out.remove(out.size()-1);
        }
    }

    public int numComponentsII(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int count = 0;
        while (head != null) {
            ListNode cur = head;
            boolean found = false;
            while (cur != null && set.contains(cur.val)) {
                found = true;
                cur = cur.next;
            }
            if (found) {
                count++;
            }
            head = cur == null ? cur : cur.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode node = GenLinkedList.genList();
        int[] G = {0, 1, 3};
        int i = numComponents(node, G);
        System.out.println(i);
    }
}
