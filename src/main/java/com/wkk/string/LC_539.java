package com.wkk.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/8/18
 */
public class LC_539 {
    public static int findMinDifference(List<String> timePoints) {
        List<Integer> list = genMinutesList(timePoints);
        Collections.sort(list);
        int ans = Integer.MAX_VALUE;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int first = list.get(i);
                int second = list.get(j);
                int curMIn = Math.min(Math.abs(first - second + 1440), Math.abs(second - first));
                ans = Math.min(ans, curMIn);
            }
        }
        return ans;
    }

    private static List<Integer> genMinutesList(List<String> strs) {
        List<Integer> list = new ArrayList<>();
        for (String str : strs) {
            String[] split = str.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            int sum = hour * 60 + minute;
            list.add(sum);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("05:31","22:08","00:35"));
        System.out.println(findMinDifference(strs));
    }
}
