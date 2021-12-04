package com.wkk.array;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/10/20
 */
public class LC_453 {
    public static int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        return Arrays.stream(nums).map(ele -> ele - min).reduce(Integer::sum).getAsInt();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1000000000};
        System.out.println(minMoves(arr));
    }

}
