package com.wkk.everyday.july;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Time: 2020/7/2上午8:15
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class KthSmallestElementInASortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                priorityQueue.offer(matrix[i][j]);
            }
        }
        while (k > 1) {
            priorityQueue.poll();
            k--;
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
    }

    public static int kthSmallestII(int[][] matrix, int k) {
        int len = matrix.length;
        // 在矩阵值范围 [min,max] 区间内二分查找第 k 小元素。
        int min = matrix[0][0], max = matrix[len - 1][len - 1];
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if (countNumbers(matrix, mid) < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private static int countNumbers(int[][] matrix, int mid) {
        int m = matrix.length - 1;
        int n = 0;
        int count = 0;
        while (m >= 0 && n <= matrix.length - 1) {
            if(matrix[m][n] <= mid){
                count += m+1;
                n++;
            }else {
                m -= 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int i = kthSmallestII(matrix, 8);
        System.out.println(i);
    }
}
