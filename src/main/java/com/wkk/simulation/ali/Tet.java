package com.wkk.simulation.ali;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/6
 */
public class Tet {
    static int n = Integer.MAX_VALUE;
    static UnionFind uf;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        uf = new UnionFind(n);
        while (T-- > 0) {
            int num = sc.nextInt();
            if (num == 1) { // 联盟
                int a = sc.nextInt();
                int b = sc.nextInt();
                calOne(a, b);
            } else { // 计算
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                calTwo(a, b, c);
            }
        }
    }

    private static void calOne(int a, int b) {
        uf.union(a,b);
    }

    private static void calTwo(int a, int b, int c) {
        int mod1 = a % c;
        int mod2 = b % c;
        boolean connect = uf.isConnect(mod1,mod2);
        if (connect) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            int rootA = find(index1);
            int rootB = find(index2);
            if (rootA != rootB) {
                parent[rootA] = rootB;
            }
        }

        public int find(int index) {
            while (index != parent[index]) {
                index = parent[index];
            }
            return index;
            // if (parent[index] != index) {
            //     parent[index] = find(parent[index]);
            // }
            // return parent[index];
        }

        public boolean isConnect(int i, int j) {
            return find(i) == find(j);
        }
    }
}
