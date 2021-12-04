package com.wkk.interview.bytedance2020;

/**
 * @Time: 2020/7/19上午8:46
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Easy_SortedMergeLCCI {
    public static void merge(int[] A, int m, int[] B, int n) {
        int[] C = new int[m + n];
        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            C[k++] = A[i] >= B[j] ? B[j++] : A[i++];
        }
        while (i < m) {
            C[k++] = A[i];
            i++;
        }
        while (j < n) {
            C[k++] = B[j];
            j++;
        }
        System.arraycopy(C, 0, A, 0, C.length);
    }

    public static void mergeII(int[] A, int m, int[] B, int n) {
        // 插入排序
        System.arraycopy(B, 0, A, m, n);
        for(int i = m; i < A.length; i++){
            int cur = A[i];
            int j = i-1;
            while(j >= 0 && A[j] >= cur){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = cur;
        }

    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 0, 0, 0};
        int[] b = {1, 2, 3};
        mergeII(a, 3,  b, 3);
    }
}
