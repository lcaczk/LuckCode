package com.wkk.newcoder.base;

/**
 * @Time: 2020/6/28上午11:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Chapter02 {
    // arr[L...R] 上的最大值
    public static int process(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        int mid = L + ((R - L) >>1);
        int left = process(arr, L, mid);
        int right = process(arr, mid + 1, R);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,7,9,0,2130,2,4,523,5};
        int process = process(arr, 0, arr.length - 1);
        System.out.println(process);
    }
}
