package com.wkk.simulation.wy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/8/21
 */
public class B {
    private static Map<Character, Character> map = new HashMap<>(26);
    private static Map<Integer, Character> orderMap = new HashMap<>(26);

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.findKthBit(4, 11));

    }

    public char findKthBit (int n, int k) {
        // write code here
        String order = "abcdefghijklmnopqrstuvwxyz";
        String reverseOrder = new StringBuilder(order).reverse().toString();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i),reverseOrder.charAt(i));
            orderMap.put(i + 1, order.charAt(i));
        }
        String str = genStr(n);
        System.out.println(str);
        return str.charAt(k - 1);
    }

    public String genStr(int n) {
        if (n == 1) {
            return "a";
        }
        String pre = genStr(n - 1);
        Character li = orderMap.get(n);
        String last = reverse(invert(pre));
        StringBuilder sb = new StringBuilder();
        sb.append(pre);
        sb.append(li);
        sb.append(last);
        return sb.toString();
    }

    private String reverse(String str) {
        int n = str.length();
        int i = 0;
        int j = n -1;
        char[] array = str.toCharArray();
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
        return new String(array);
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private String invert(String str) {
        int n = str.length();
        char[] array = str.toCharArray();
        for (int i = 0; i < n; i++) {
            array[i] = map.get(array[i]);
        }
        return new String(array);
    }
}
