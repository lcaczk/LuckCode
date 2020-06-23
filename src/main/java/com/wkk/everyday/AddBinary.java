package com.wkk.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 2020/6/23下午7:15
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        Deque<Integer> stackA = str2Stack(a);
        Deque<Integer> stackB = str2Stack(b);
        int carry = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            int c = stackA.isEmpty() ? 0 : stackA.pop();
            int d = stackB.isEmpty() ? 0 : stackB.pop();

            int sum = c + d + carry;
            int i = sum % 2;
            stack.push(i);
            carry = sum / 2;
        }
        if(carry >0){
            stack.push(carry);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();

    }

    public Deque<Integer> str2Stack(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i) - '0');
        }
        return stack;
    }

    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        AddBinary binary = new AddBinary();
        String s = binary.addBinary(a, b);
        System.out.println(s);
    }
}
