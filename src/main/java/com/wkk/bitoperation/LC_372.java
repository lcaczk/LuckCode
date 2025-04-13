package com.wkk.bitoperation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/12/5
 */
public class LC_372 {
    private int mod = 1337;

    public int superPow(int n, int[] nums) {
        Deque<Integer> list = new ArrayDeque<>();
        for (int e : nums) {
            list.add(e);
        }

        return myPow(n, list);
    }

    private int myPow(int n, Deque<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        Integer last = list.removeLast();
        n = n % mod;
        int part1 = quickPow(n, last);
        int part2 = quickPow(myPow(n, list), 10);
        return (part1 * part2) % mod;
    }

    private int quickPow(int n, int k) {
        int res = 1;
        while (k != 0) {
            if ((k & 1) == 1) {
                res = res * n % mod;
            }
            k >>= 1;
            n = n * n % mod;
        }
        return res % mod;
    }
}
