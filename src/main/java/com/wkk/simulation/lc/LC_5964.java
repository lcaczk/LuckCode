package com.wkk.simulation.lc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/12/26
 */
public class LC_5964 {
    private int n;
    private Map<Character, int[]> map;
    private List<Integer> list;

    public int[] executeInstructions(int n, int[] startPos, String s) {
        this.n = n;
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        map.put('L', new int[]{0, -1});
        map.put('R', new int[]{0, 1});
        map.put('D', new int[]{1, 0});
        map.put('U', new int[]{-1, 0});

        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            String subStep = s.substring(i, sLen);
            countStep(subStep, startPos);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void countStep(String steps, int[] position) {
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        int[] cur = new int[] {position[0], position[1]};
        queue.offer(cur);
        boolean all = true;
        int size = list.size();
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (count >= steps.length()) {
                break;
            }
            char nextStep = steps.charAt(count);
            int[] ints = map.get(nextStep);
            now[0] += ints[0];
            now[1] += ints[1];
            if (!isPos(now[0], now[1])) {
                list.add(count);
                all = false;
                break;
            }
            count++;
            queue.offer(new int[]{now[0], now[1]});
        }
        if (all) {
            if (size < list.size()) {
                list.remove(list.size() - 1);
                list.add(steps.length());
            } else {
                list.add(count);
            }
        }
    }

    private boolean isPos(int i, int j) {
        return (i >= 0 && i < n) && (j >= 0 && j < n);
    }

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {0, 1};
        String str = "RRDDLU";
        LC_5964 lc_5964 = new LC_5964();
        int[] ints = lc_5964.executeInstructions(n, arr, str);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
