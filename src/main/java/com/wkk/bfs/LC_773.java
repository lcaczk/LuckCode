package com.wkk.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/6/26
 */
public class LC_773 {
    int[][] steps = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int slidingPuzzle(int[][] board) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String target = "123450";
        String initial = sb.toString();
        if (target.equals(initial)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(initial);
        Map<String, Integer> map = new HashMap<>();
        map.put(initial, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String curStatus = queue.poll();
                if (curStatus.equals(target)) {
                    return map.get(curStatus);
                }
                int pos = curStatus.indexOf("0");
                int x = pos / 3;
                int y = pos % 3;
                for (int[] dis : steps) {
                    int nx = x + dis[0];
                    int ny = y + dis[1];
                    if (!isPow(nx, ny)) {
                        continue;
                    }
                    String nextStatus = makeStr(curStatus, pos, nx * 3 + ny);
                    if (map.containsKey(nextStatus)) {
                        continue;
                    }
                    map.put(nextStatus, map.get(curStatus) + 1);
                    queue.offer(nextStatus);

                }
            }
        }
        return -1;
    }

    private boolean isPow(int x, int y) {
        return (x >= 0 && x < 2) && (y >= 0 && y < 3);
    }

    private String makeStr(String t, int src, int dest) {
        StringBuilder sb = new StringBuilder(t);
        sb.setCharAt(src, t.charAt(dest));
        sb.setCharAt(dest, '0');
        return sb.toString();
    }


    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 0, 5}};
        LC_773 lc_773 = new LC_773();
        System.out.println(lc_773.slidingPuzzle(a));
    }
}
