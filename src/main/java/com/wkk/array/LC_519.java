package com.wkk.array;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/11/27
 */
public class LC_519 {
    // 思路 二维转一维
    // 然后使用自带的random
    private Random random = new Random();
    private int m;
    private int n;
    private int total;
    private Set<Integer> set = new HashSet<>();
    private int[][] matrix;

    public LC_519(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.matrix = new int[m][n];
    }

    public int[] flip() {
        int next = random.nextInt(total);
        while (set.contains(next)) {
            next = random.nextInt(total);
        }
        int[] arr = one2Two(next);
        // matrix[arr[0]][arr[1]] = 1;
        set.add(next);
        return arr;
    }

    public void reset() {
        set = new HashSet<>();
    }

    private int[] one2Two(int num) {
        int[] arr = new int[2];
        arr[0] = num / n;
        arr[1] = num % n;
        return arr;
    }
}
