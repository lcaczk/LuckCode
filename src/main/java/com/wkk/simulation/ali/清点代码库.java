package com.wkk.simulation.ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/8/4
 */
public class 清点代码库 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        cal(matrix);
    }

    private static void cal(int[][] matrix) {
        // key : int[]
        // value : count
        int rows = matrix.length;
        int cols = matrix[0].length;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int[] tmp : matrix) {
            List<Integer> list = Arrays.stream(tmp).boxed().collect(Collectors.toList());
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        int n = map.size();
        int[][] ans = new int[n][cols + 1];
        System.out.println(n);
        List<Map.Entry<List<Integer>, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<List<Integer>, Integer>>() {
            @Override
            public int compare(Map.Entry<List<Integer>, Integer> o1, Map.Entry<List<Integer>, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    if (compareOwn(o1.getKey(), o2.getKey())) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        int idx = 0;
        for (Map.Entry<List<Integer>, Integer> entry : entries) {
            ans[idx][0] = entry.getValue();
            for (int i = 1; i <= cols; i++) {
                ans[idx][i] = entry.getKey().get(i - 1);
            }
            idx++;
        }
        printMatrix(ans, ans.length, ans[0].length);
    }

    private static boolean compareOwn(List<Integer> fist, List<Integer> second) {
        int n = fist.size();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (fist.get(i) > second.get(i)) {
                flag = false;
            }
        }
        return flag;
    }

    private static void printMatrix(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
