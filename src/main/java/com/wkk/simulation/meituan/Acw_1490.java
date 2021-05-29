package com.wkk.simulation.meituan;

import java.io.IOException;
import java.util.Scanner;

/**
 * 最长上升子串
 * @author weikunkun
 * @since 2021/5/17
 */
public class Acw_1490 {
    private static int len;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        int[] array = new int[len];
        int i = 0;
        while (i < len) {
            array[i] = sc.nextInt();
            i++;
        }
//        int ans = 1;
//        for (int j = 0; j < len; j++) {
//            ans = Math.max(ans, getMax(array, j));
//        }
        System.out.println(getMax(array));


    }

    /**
     * 前缀求解
     * 解决超时问题
     * @param array
     * @return
     */
    private static int getMax(int[] array) {
        int length = array.length;
        int[] startPrefix = new int[length];
        int[] endPrefix = new int[length];
        for (int i = 1; i <= len; i++) {
            if (array[i] > array[i-1]) {
                endPrefix[i] = endPrefix[i-1] + 1;
            } else {
                endPrefix[i] = 1;
            }
        }

        for (int i = len; i >= 1; i--) {
            if (array[i] < array[i+1]) {
                startPrefix[i] = startPrefix[i+1] + 1;
            } else {
                startPrefix[i] = 1;
            }
        }
        int max = 0;
        for (int i = 1; i <= len; i++) {
            int start = startPrefix[i + 1];
            int end = endPrefix[i - 1];
            if (array[i-1] < array[i + 1]) {
                max = Math.max(max, start + end);
            } else {
                max = Math.max(max, Math.max(start, end));
            }
        }
        return max;
    }


    /**
     * 暴力解决 超时
     * @param array
     * @param deleteIdx
     * @return
     */
    private static int getMax(int[] array, int deleteIdx) {
        //
        int len = array.length;
        array = genRemovedArray(array, deleteIdx);
        int max = 1;
        int innerMax = 1;
        for (int i = 1; i < len - 1; i++) {
            if (array[i] > array[i-1]) {
                innerMax +=1;
                max = Math.max(innerMax, max);
            } else {
                innerMax = 1;
            }
        }
        return max;
    }

    private static int[] genRemovedArray(int[] array, int idx) {
        int len = array.length;
        int[] res = new int[len - 1];
        int numMoved = len - idx - 1;
        System.arraycopy(array, 0, res, 0, idx);
        System.arraycopy(array, idx + 1, res, idx, numMoved);
        return res;
    }
}
