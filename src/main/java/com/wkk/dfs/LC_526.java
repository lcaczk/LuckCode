package com.wkk.dfs;

/**
 * @author weikunkun
 * @since 2021/8/16
 */
public class LC_526 {
    private int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        dfs(n, 1, visited);
        return count;
    }

    private void dfs(int n, int idx, boolean[] visited) {
        if (idx == n + 1) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (!jude(idx, i)) {
                continue;
            }
            visited[i] = true;
            dfs(n, idx + 1, visited);
            visited[i] = false;
        }
    }

    private boolean jude(int num, int idx) {
        return num % idx == 0 || idx % num == 0;
    }
}
