package com.wkk.simulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/20
 */
public class UF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        UnionFind uf = new UnionFind(n + 1);
        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            uf.union(a, b);
        }
        for (int i = 1; i <= n; i++) {
            if (uf.find(i) == 0) {
                continue;
            }
            System.out.println(uf.find(i) + " ");
        }
    }

    static class UnionFind {
        private int count;
        // 核心，对应的父节点
        private int[] parents;
        // 每个树的节点数量 （每个连通分量的大小）
        private int[] nums;

        public UnionFind(int n) {
            this.count = 0;
            this.parents = new int[n + 1];
            this.nums = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parents[i] = i;
                nums[i] = 1;
            }
        }

        public int find(int x) {
             if (x == parents[x]) {
                 return x;
             }
             return parents[x] = find(parents[x]);
//            while (x != parents[x]) {
//                x = parents[x];
//            }
//            return x;
        }

        public void union(int x, int y) {
            int rootA = find(x);
            int rootB = find(y);
            if (rootA == rootB) {
                int max = getMax();
                System.out.println(max - nums[rootA]);
                return;
            }
            int max = Math.max(rootA, rootB);
            int min = Math.min(rootA, rootB);
            parents[min] = max;
            nums[max] += nums[min];
            count--;
        }

        public int getMax() {
            return Arrays.stream(nums).max().getAsInt();
        }

        public boolean isConnect(int x, int y) {
            return  find(x) == find(y);
        }

        public int getCount() {
            return count;
        }

        public void add(int idx) {
            count++;
        }
    }
}
