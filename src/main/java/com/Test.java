package com;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/5/9
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(7);
        int n = 10;
        n >>>= 1;
        System.out.println(n);
    }
}
