package com.wkk.weekcompete;

/**
 * @author weikunkun
 * @since 2021/4/18
 */
public class LC_5737 {
    public static int getXORSum(int[] arr1, int[] arr2) {
        int sum2 = 0;
        int ret = 0;
        for (int i : arr2) {
            sum2^=i;
        }
        for(int i:arr1){
            ret ^= (i&sum2);
        }
        return ret;
    }

    public int getXORSumII(int[] arr1, int[] arr2) {
        int sum2 = 0;
        int ret = 0;
        for (int i : arr2) {
            sum2 ^= i;
        }
        for(int i:arr1){
            ret ^= i;
        }
        return ret & sum2;
    }

    public static void main(String[] args) {
        int[] arr1 = {12,8};
        int[] arr2 = {4};
        System.out.println(getXORSum(arr1, arr2));
    }
}
