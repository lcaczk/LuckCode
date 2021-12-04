package com.wkk.simulation.mt;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class 争夺地盘 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("c");
        set2.add("d");
        set2.add("e");

        set1.retainAll(set2);
        System.out.println(set1);
    }
}
