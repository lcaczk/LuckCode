package com.wkk.array;

import java.util.stream.IntStream;

/**
 * @author weikunkun
 * @since 2021/11/1
 */
public class LC_575 {
    public int distributeCandies(int[] candyType) {
        // 思路
        // 贪心， 划分最多
        // 因为每个人都能得到一半的数量，所以尽可能保证不唯一即可
        // 共有m糖果、n个糖果
        // 1: m <= n / 2 返回m
        // 2: m > n / 2 返回 n / 2
        return Math.min((int)IntStream.of(candyType).distinct().count(), candyType.length / 2);
    }
}
