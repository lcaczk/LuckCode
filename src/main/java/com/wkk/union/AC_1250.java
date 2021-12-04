package com.wkk.union;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/9
 */
public class AC_1250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int T = Integer.parseInt(arr[1]);
        int j = 0;
        UninFind uf = new UninFind(n * (n + 1));
        int x, y, nx, ny,fist, second;
        boolean flag = true; // 始终没有结束
        while (j < T) {
            arr = sc.nextLine().split(" ");
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            String forward = arr[2];
            if (forward.equals("D")) {
                nx = x + 1;
                fist = sift(x, y, n);
                second = sift(nx, y, n);
                if (uf.isConnect(fist, second)) {
                    flag = false;
                    System.out.println(j + 1);
                    break;
                } else {
                    uf.union(fist, second);
                }

            } else {
                ny = y + 1;
                fist = sift(x, y, n);
                second = sift(x, ny, n);
                if (uf.isConnect(fist, second)) {
                    flag = false;
                    System.out.println(j + 1);
                    break;
                } else {
                    uf.union(fist, second);
                }
            }
            j++;
        }

        if (flag) {
            System.out.println("draw");
        }
    }

    private static int sift(int x, int y, int n) {
        return x * n + y;
    }

    public static class UninFind {
        private int[] parents;

        public UninFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        private int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        private void union(int x, int y) {
            int rootA = find(x);
            int rootB = find(y);
            if (rootB != rootA) {
                parents[rootA] = rootB;
            }
        }

        private boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }
    }
}
