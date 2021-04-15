package com.wkk.bytedance2021.simulation;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 一般这种数对，还涉及排序的，
 * 根据第一个元素正向排序，根据第二个元素反向排序，
 * 或者根据第一个元素反向排序，根据第二个元素正向排序，
 * 往往能够简化解题过程。
 * @author weikunkun
 * @since 2021/4/14
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[] array = {46,79,56,38,40,84};
        Arrays.sort(array);
        Arrays.stream(array).forEach(System.out::println);

    }
}
