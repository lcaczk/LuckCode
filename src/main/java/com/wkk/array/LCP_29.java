package com.wkk.array;

/**
 * @author weikunkun
 * @since 2021/9/6
 */
public class LCP_29 {
    private static int mod = 9;
    public static int orchestraLayout(int num, int xPos, int yPos) {
        // 螺旋矩阵逆向输出
        int[][] matrix = new int[num][num];
        int idx = 1;
        int[] base = new int[9];
        for (int i = 1; i < 9; i++) {
            base[i] = i;
        }
        base[0] = 9;
        int l = 0, t = 0;
        int r = num - 1, b = num - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                matrix[t][i] = base[idx % mod];
                idx++;
            }
            if (++t > b) {
                break;
            }

            for (int i = t; i <= b; i++) {
                matrix[i][r] = base[idx % mod];
                idx++;
            }
            if (--r < l) {
                break;
            }

            for (int i = r; i >= l; i--) {
                matrix[b][i] = base[idx % mod];
                idx++;
            }
            if (--b < t) {
                break;
            }

            for (int i = b; i >= t; i--) {
                matrix[i][l] = base[idx % mod];
                idx++;
            }
            if (++l > r) {
                break;
            }
        }
        printArr(base);
        print(matrix, num);
        return matrix[xPos][yPos];
    }
    private static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void print(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        orchestraLayout(4, 1, 2);
    }
}
