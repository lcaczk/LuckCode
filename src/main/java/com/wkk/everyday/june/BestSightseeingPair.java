package com.wkk.everyday.june;

/**
 * @Time: 2020/6/17上午7:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BestSightseeingPair {
    // 暴力解法 会超出时间限制
    public int maxScoreSightseeingPair(int[] A) {
        int ans = A[0];
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int temp = A[j] + A[i] + i - j;
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }

    // 优化
    public int maxScoreSightseeingPairII(int[] A) {
        int ans = A[0];
        int mx = A[0] + 0;
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, mx + A[i] - i);
            mx = Math.max(mx, A[i] + i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {8, 1, 5, 2, 6};
        BestSightseeingPair pair = new BestSightseeingPair();
        int i = pair.maxScoreSightseeingPair(a);
        System.out.println(i);
    }
}
