package com.wkk.dp;

/**
 * 116. 跳跃游戏
 * @author weikunkun
 * @since 2021/3/11
 */
public class LC_116 {
    public boolean canJump(int[] A) {
        // write your code here
        int len = A.length;
        boolean[] res = new boolean[len];
        res[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && j + A[j] >= i) {
                    res[i] = true;
                }
            }
        }
        return res[len - 1];

    }
}
