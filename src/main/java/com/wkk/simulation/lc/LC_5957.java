package com.wkk.simulation.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/12/19
 */
public class LC_5957 {
    public String addSpaces(String s, int[] spaces) {
        char[] arr = s.toCharArray();
        Map<Integer, Character> map = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            map.put(i,arr[i]);
        }

        int slen = spaces.length;
        for (int i = 0; i < slen; i++) {
            spaces[i] -= 1;
        }

        Set<Integer> set = Arrays.stream(spaces).boxed().collect(Collectors.toSet());
        StringBuilder sb = new StringBuilder();

        if (set.contains(-1)) {
            sb.append(" ");
        }

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            if (set.contains(i)) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
