package com.wkk.array;

/**
 * @author weikunkun
 * @since 2021/8/14
 */
public class LC_1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // close[i][j]表示 i 和 j 的亲密程度
        int[][] close = new int[n][n];
        // teammate[i]表示 i 的队友是谁
        int[] teammate = new int[n];
        // 整理亲密程度
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                // 数值越小越亲近
                close[i][preferences[i][j]] = j;
            }
        }
        // 整理配对情况
        for (int[] pair : pairs) {
            teammate[pair[0]] = pair[1];
            teammate[pair[1]] = pair[0];
        }

        // 使用set一次可以找到两个人
        // 但是运行时间更慢了
        // 所以我们不是一个一个找
        int ans = 0;

        // 遍历所有的n个人
        for (int x = 0; x < n; x++) {
            // 找到 x 的队友 y
            int y = teammate[x];
            // 看看有没有亲密程度排在y之前的，即可能的u
            for (int u : preferences[x]) {
                if (u == y) {
                    break;
                }
                // 在y之前找到一个可能的u
                // 看u与x的亲密程度是否大于u的队友v
                int v = teammate[u];
                if (close[u][x] < close[u][v]) {
                    ans++;
                    // x已经确定不开心了，寻找下一个吧
                    break;
                }
            }
        }

        return ans;
    }
}
