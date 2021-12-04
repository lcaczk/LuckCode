package com.wkk.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/11
 */
public class 路径 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[][] matrix = genMatrix(s);
        System.out.println(cal(matrix));
    }

    private static int cal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return 0;
    }

    private static int[][] genMatrix(String s) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp.add(c - '0');
            } else if (c == ';') {
                list.add(tmp);
                tmp = new ArrayList<>();
            }
        }
        int[][] matrix = new int[list.size()][list.get(0).size()];
        int i = 0;
        for (List<Integer> integers : list) {
            matrix[i] = integers.stream().mapToInt(a->a).toArray();
        }
        return matrix;
    }
}
