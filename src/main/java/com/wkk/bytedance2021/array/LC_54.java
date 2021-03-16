package com.wkk.bytedance2021.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/3/16
 */
public class LC_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 思路 模拟进行
        List<Integer> result = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int l = 0;
        int r = matrix[0].length -1;
        int t = 0;
        int b = matrix.length -1 ;
        while (true) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                result.add(matrix[b][i]);
            }
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {
                result.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return result;
    }
}
