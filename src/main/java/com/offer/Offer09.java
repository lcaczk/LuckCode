package com.offer;

import java.util.LinkedList;

/**
 * 题目：剑指 Offer 09.用两个栈实现队列
 * 题目链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 标签：栈 设计
 * <p>
 * 题目描述：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
 * 功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
class CQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    // 直接向stack1末尾添加
    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {
        // 如果stack2为空，将stack1元素全部移入stack2
        if (stack2.size() == 0) {
            int n = stack1.size();
            for (int i = 0; i < n; i++) {
                stack2.addLast(stack1.removeLast());
            }
        }
        // 返回stack2栈顶元素
        if (stack2.size() == 0) {
            return -1;
        } else {
            return stack2.removeLast();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

public class Offer09 {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        obj.appendTail(2);
        obj.appendTail(3);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}
