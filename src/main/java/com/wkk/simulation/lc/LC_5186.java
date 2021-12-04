package com.wkk.simulation.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/11/21
 */
public class LC_5186 {
    // map key cur   value list
    Map<Integer, List<Integer>> map = new HashMap<>();

    public LC_5186(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], list -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = map.getOrDefault(value, new ArrayList<>());
        if (list.isEmpty()) {
            return 0;
        }
        int l = list.get(0);
        int r = list.get(list.size() - 1);
        if (r < left) {
            return 0;
        } else if (l > right) {
            return 0;
        } else if (l > left && r < right) {
            return r - l + 1;
        } else if (l > left && right < r) {
            return search(list, right) - search(list, l);
        } else if (l < left && r < right) {
            return search(list, r) -search(list, left);
        }
        return 0;
    }

    private int search(List<Integer> list, int target) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (list.get(mid) < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return list.get(i) == target ? i : -1;
    }

    public static void main(String[] args) {
//        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
//        int[] arr = {1, 1, 1, 2, 2};
//        LC_5186 lc_5186 = new LC_5186(arr);
//        System.out.println(lc_5186.query(0, 11, 33));
//        System.out.println(lc_5186.query(0, 1, 2));
        char[] arr = new char[5];
        arr[0] = 'a';
        arr[3] = 'b';
        String s = new String(arr);
        System.out.println(s);

    }
}
