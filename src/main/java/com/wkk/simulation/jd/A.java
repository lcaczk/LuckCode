package com.wkk.simulation.jd;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/11
 */
public class A {
    private static int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        n = array[0];
        m = array[1];
        int x = array[2];
        int y = array[3];
        int z = array[4];
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        char[] arr = sc.nextLine().toCharArray();
        cal(matrix, n, m, x, y, z, arr);
    }

    /**
     * @param matrix
     * @param n
     * @param m
     * @param x      移动
     * @param y      转向
     * @param z      点击
     */
    private static void cal(char[][] matrix, int n, int m, int x, int y, int z, char[] arr) {
        // bfs
        // 0 上
        // 1 下
        // 2 左
        // 3 右
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, -1, 0, matrix[0][0]));
        int idx = 0;
        Node p;
        int sum = 0;
        boolean reduce = false;
        for (int[] step : steps) {
            int nx = matrix[0][0] + step[0];
            int ny = matrix[0][1] + step[1];
            if (!isPow(nx, ny)) {
                continue;
            }
            if (matrix[nx][ny] == arr[0]) {
                reduce = true;
            }
        }
        int len = arr.length;
        while (!queue.isEmpty()) {
            if (idx >= len) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (p.value == arr[idx]) {
                    idx++;
                    sum += p.w;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + steps[j][0];
                    int ny = p.y + steps[j][1];
                    if (!isPow(nx, ny)) {
                        continue;
                    }
                    Node next = new Node();
                    next.value = matrix[nx][ny];
                    next.x = nx;
                    next.y = ny;
                    next.forword = j;
                    if (p.forword != j) {
                        if (Character.isLetter(next.value)) {
                            next.w = p.w + x + y + z;
                        } else {
                            next.w = p.w + x + y;
                        }
                    } else {
                        if (Character.isLetter(next.value)) {
                            next.w = p.w + x + z;
                        } else {
                            next.w = p.w + x;
                        }
                    }
                    queue.offer(next);
                }
            }
        }
        if (reduce) {
            System.out.println(sum - x - y - z);
        } else {
            System.out.println(sum - x - y);
        }
    }

    private static boolean isPow(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }

    private static class Node {
        public int x;
        public int y;
        public int forword;
        public long w;
        public char value;

        Node() {

        }

        Node(int x, int y, int forword, long w, char value) {
            this.x = x;
            this.y = y;
            this.forword = forword;
            this.w = w;
            this.value = value;
        }
    }
}
