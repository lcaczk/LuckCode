package com.wkk.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/6/25
 */
public class LC_752 {
    private Set<String> set; // 存储 死亡字符
    private Set<String> visited; // 是否已经访问过
    public int openLock(String[] deadends, String target) {
        // 思路
        // 暴力搜索问题
        // 每个元素 当前都可以 有8次的变化
        // 4位数组 都有上下波动的可能
        // 注意 0 的切换
        // 如果为 deadends continue
        set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }
        int count = 0;
        Deque<String>  queue = new ArrayDeque<>();
        if (set.contains("0000")) {
            return -1;
        }
        queue.offer("0000");
        String pop;
        visited = new HashSet<>();
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                pop = queue.poll();
                if (pop.equals(target)) {
                    return count;
                }
                // 拨动 pop
                for (int i = 0; i < pop.length(); i++) {
                    String upStr = siftUp(pop, i);
                    String downStr = siftDown(pop, i);
                    if (normalStr(upStr)) {
                        queue.offer(upStr);
                        visited.add(upStr);
                    }
                    if (normalStr(downStr)) {
                        queue.offer(downStr);
                        visited.add(downStr);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private boolean normalStr(String s) {
        return !visited.contains(s) && !set.contains(s);
    }

    private String siftUp(String tmp, int idx) {
        char[] chs = tmp.toCharArray();
        if (chs[idx] == '9') {
            chs[idx] = '0';
        } else {
            chs[idx] += 1;
        }
        return new String(chs);
    }

    private String siftDown(String tmp, int idx) {
        char[] chs = tmp.toCharArray();
        if (chs[idx] == '0') {
            chs[idx] = '9';
        } else {
            chs[idx] -= 1;
        }
        return new String(chs);
    }

    public static void main(String[] args) {
    }
}
