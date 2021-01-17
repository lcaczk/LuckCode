package com.wkk.everyday.jun;

/**
 * @author kongwiki@163.com
 * @since 2021/1/17
 */
public class LC1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length == 0) {
            return true;
        }
        int m = coordinates.length;
        int n = coordinates[0].length;
        // y = kx + b;
        // 1. 行数<2
        if (m <= 2) {
            return true;
        }
        // 2. 分子为0情况
        if (isXAllSame(coordinates)) {
            return true;
        }
        if (isXPartSamp(coordinates)) {
            return false;
        }
        // 3. 正常情况
        // k = (y1-y2)/(x1-x2);
        // b = y1-kx1
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        float k = (y2-y1)/(float)(x2 - x1);
        float b = y1 - k*x1;
        for(int[] ints : coordinates) {
            if (k*ints[0] + b != ints[1]){
                return false;
            }
        }
        return true;
    }

    /**
     * 用于判断是否是x1-x2=0的情况
     * 1. 整体相同 true
     */
    private boolean isXAllSame(int[][] coordinates) {
        int temp = coordinates[0][0];
        for(int i = 1; i<coordinates.length; i++){
            if (coordinates[i][0] != temp) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用于判断是否是x1-x2=0的情况
     * 1. 部分相同 false
     */
    private boolean isXPartSamp(int[][] coordinates) {
        int temp = coordinates[0][0];
        for(int i = 1; i<coordinates.length; i++){
            if (coordinates[i][0] == temp) {
                return true;
            }
        }
        return false;
    }

    /**
     * 先平移再做判断
     * y = kx + b ==> y' = k'x;
     * @param coordinates
     * @return
     */
    public boolean checkStraightLineII(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
