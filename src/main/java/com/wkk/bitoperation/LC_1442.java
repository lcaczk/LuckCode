package com.wkk.bitoperation;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 *
 * @author weikunkun
 * @since 2021/5/18
 */
public class LC_1442 {
    /**
     * 前缀异或
     * @param arr
     * @return
     */
    public static int countTriplets(int[] arr) {
        // for 循环
        int len = arr.length;
        int count = 0;
        int[] preOr = new int[len + 1];
        for (int i = 1; i < len+1; i++) {
            count ^= arr[i-1];
            preOr[i] = count;
        }
        count = 0; // 因为使用cout做了额外运算，所以重新置0
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j; k < len; k++) {
                    // 计算
                    int a = preOr[i] ^ preOr[j];
                    int b = preOr[j] ^ preOr[k+1];
                    if (a == b) {
                        count++;
                    }
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7, 9};
        countTriplets(arr);
    }
}
