package com.wkk.array;

/**
 * @author weikunkun
 * @since 2021/7/31
 */
public class LC_1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        // 优化为O(n)
        int res = 0;
        int[] ans = new int[100];
        for (int[] dominoe : dominoes) {
            int val = genOnlyOneNum(dominoe);
            ans[val]++;
            if (ans[val] >= 2) {
                res += ans[val] - 1;
            }
        }
        return res;
    }

    private int genOnlyOneNum(int[] nums) {
        int res = nums[0] > nums[1] ? nums[0] * 10 + nums[1] : nums[1] * 10 + nums[0];
        return res;
    }

    public static void main(String[] args) {
        LC_1128 lc_1128 = new LC_1128();
        int[][] matrix = {{1, 1}, {2, 2}, {1, 1}, {1, 2}, {1, 2}, {1, 1}};
        lc_1128.numEquivDominoPairs(matrix);
    }
}
