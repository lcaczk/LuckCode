package com.wkk.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/6/3
 */
public class LC_403 {
    private Map<Integer, Integer> map;
    private Map<String, Boolean> cache = new HashMap<>();
    public boolean canCross(int[] stones) {
        // 通常设计 DFS 函数时，我们只需要不失一般性的考虑完成第 ii 块石子的跳跃需要些什么信息即可：
        //     需要知道当前所在位置在哪，也就是需要知道当前石子所在列表中的下标 uu。也就是跳到了第几块儿石头上
        //     需要知道当前所在位置是经过多少步而来的，也就是需要知道上一步的跳跃步长 kk。
        map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        if (!map.containsKey(1)) {
            return false;
        }
        // dfs: 能否渡过河
        return dfs(stones, stones.length, 1, 1);
    }

    private boolean dfs(int[] stones, int len, int idx, int step) {
        String key = idx + "_" + step;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (idx == len - 1) {
            return true;
        }
        // 2种情况
        for (int i = -1; i <= 1; i++) {
            if ((step + i) == 0) {
                continue;
            }
            int curStep = step + i;
            int next = stones[idx] + curStep;
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, len, map.get(next), curStep);
                cache.put(key, cur);
                if (cur) {
                    return true;
                }
            }
        }
        return false;
    }
}
