package com.wkk.simulation.xp;

/**
 * @author weikunkun
 * @since 2021/9/6
 */
public class A {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param s string字符串
     * @return string字符串一维数组
     */
    String[] ans;
    int index = 0;

    public String[] permutation(String S) {
        if (S == null || S.length() == 0) {
            return new String[]{};
        }
        int[] inf = new int[]{1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        ans = new String[inf[S.length() - 1]];
        char[] vals = S.toCharArray();
        backtrack(vals, 0);
        return ans;
    }

    public void backtrack(char[] vals, int start) {
        if (start == vals.length) {
            ans[index++] = String.valueOf(vals);
            return;
        }
        for (int i = start; i < vals.length; i++) {
            swag(vals, i, start);
            backtrack(vals, start + 1);
            swag(vals, i, start);
        }
    }

    public void swag(char[] vals, int i, int j) {
        char tmp = vals[i];
        vals[i] = vals[j];
        vals[j] = tmp;
    }
}
