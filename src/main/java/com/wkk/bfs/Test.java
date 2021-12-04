package com.wkk.bfs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/9/3
 */
public class Test {
    public static void main(String[] args) {
       int[] arr = {1,2,3};
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
