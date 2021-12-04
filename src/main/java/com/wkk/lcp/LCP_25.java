package com.wkk.lcp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/10/1
 */
public class LCP_25 {
    private int mod = (int) 1e9 + 7;
    Map<Integer, Long> maps = new HashMap<>();

    public int keyboard(int k, int n) {
        int[] dp = new int[k + 1];
        dp[k] = 26;
        return (int) (dfs(dp, n, k) % mod);
    }


    private long dfs(int[] map, int n, int limit) {
        int state = getState(map);
        if (!maps.containsKey(state)) {
            long res = 0;
            if (n == 1) {
                for (int i = 1; i <= limit; i++) {
                    res += map[i];
                }
            } else {
                for (int i = 1; i <= limit; i++) {
                    if (map[i] != 0) {
                        map[i]--;
                        map[i - 1]++;

                        res += (map[i] + 1) * dfs(map, n - 1, limit);
                        res %= mod;

                        // 回溯
                        map[i]++;
                        map[i - 1]--;
                    }
                }
            }
            maps.put(state, res);
            return res;
        }
        return maps.get(state);
    }

    public int getState(int[] map) {
        int cur = 0;
        for (int i = 1; i < map.length; i++) {
            cur *= 27;
            cur += map[i];
        }
        return cur;
    }
}
