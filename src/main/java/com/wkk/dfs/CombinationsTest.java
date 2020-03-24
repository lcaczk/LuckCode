package com.wkk.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-23上午9:53
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CombinationsTest {
    public static void dfs(int start, int n, int[] a, int[] book) {
        // 终止条件(判断边界)
        if (start == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }
        // 尝试每一种可能
        for (int i = 1; i <= n; i++) {
            if (book[i - 1] == 0) {
                a[start] = i;
                book[i - 1] = 1;
                dfs(start + 1, n, a, book);
                book[i - 1] = 0;
            }
        }

    }

    // 优化 使用list
    static void dfsII(int start, int k, int n, List<Integer> list) {
        if (list.size() == k) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                dfsII(start + 1, k, n, list);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int n = 4;
//        int[] a = new int[n];
//        // 索引为对应的元素
//        int[] book = new int[n];
//        dfs(0, n, a, book);
//        System.out.println();
        List<Integer> list = new LinkedList<>();
        dfsII(1, 2, n, list);

    }
}
