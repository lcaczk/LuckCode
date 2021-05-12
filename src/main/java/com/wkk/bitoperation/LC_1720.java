package com.wkk.bitoperation;

/**
 *
 * @author weikunkun
 * @since 2021/5/11
 */
public class LC_1720 {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] ans = new int[len + 1];
        ans[0] =  first;
        for (int i = 1; i <= len; i++) {
            ans[i] = encoded[i-1] ^ ans[i-1];
        }
        return ans;
    }
}
