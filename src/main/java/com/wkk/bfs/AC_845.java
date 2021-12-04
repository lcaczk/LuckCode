package com.wkk.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/15
 */
public class AC_845 {
    private static int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = sc.nextLine();
        cal(s);
    }

    private static void cal(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        Queue<String> queue = new LinkedList<>();
        String init = sb.toString();
        String target = "12345678x";
        queue.offer(init);
        Map<String, Integer> map = new HashMap<>();
        map.put(init, 0);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    System.out.println(map.get(cur));
                    flag = true;
                    break;
                }
                int pos = cur.indexOf('x');
                // 转化为当前的二维位置
                int x = pos / 3;
                int y = pos % 3;
                for (int[] step : steps) {
                    int nx = x + step[0];
                    int ny = y + step[1];
                    if (!isPos(nx, ny)) {
                        continue;
                    }
                    String nextStr = makeStr(cur, pos, nx * 3 + ny);
                    if (map.containsKey(nextStr)) { // 只记录第一出现的时候，保证最短路径
                        continue;
                    }
                    map.put(nextStr, map.get(cur) + 1);
                    queue.offer(nextStr);
                }

            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

    private static boolean isPos(int x, int y) {
        return (x >= 0 && x < 3) && (y >= 0 && y < 3);
    }

    private static String makeStr(String str, int src, int dist) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(dist, 'x');
        sb.setCharAt(src, str.charAt(dist));
        return sb.toString();
    }
}
