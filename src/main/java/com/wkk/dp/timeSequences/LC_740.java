package com.wkk.dp.timeSequences;

/**
 * 经典的时间序列模型
 * 不过需要提炼出题意
 * @author weikunkun
 * @since 2021/5/5
 */
public class LC_740 {
    static int[] cnts = new int[10009];

    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int x : nums) {
            cnts[x]++;
            max = Math.max(max, x   );
        }
        // f[i][0] 代表「不选」数值 i；f[i][1] 代表「选择」数值 i
        int[][] f = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            f[i][1] = f[i - 1][0] + i * cnts[i];
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
        }
        return Math.max(f[max][0], f[max][1]);
    }

    public static void main(String[] args) {
        int[] array = {2, 2, 3, 3, 3, 4};
        deleteAndEarn(array);
    }
}
