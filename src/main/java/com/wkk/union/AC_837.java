package com.wkk.union;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/9/20
 */
public class AC_837 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.stream(arr).forEach(i -> {
            System.out.println(i + 1);
        });
        Arrays.stream(arr).forEach(System.out::println);
    }
}
