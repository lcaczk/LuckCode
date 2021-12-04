package com.wkk.simulation.acwing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/8/14
 */
public class AC_3804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            String str = sc.nextLine();
            cal(str, n, k);
        }
    }

    private static void cal(String str, int n, int k) {
        // 贪心
        char[] arr = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch : arr) {
            set.add(ch);
        }
        List<Character> list = new ArrayList<>(set);
        Collections.sort(list);
        char[] standard = new char[list.size()];
        int idx = 0;
        for (Character character : list) {
            standard[idx++] = character;
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> idxMap = new HashMap<>();
        int m = standard.length;
        for (int i = 0; i < m; i++) {
            map.put(standard[i], i);
            idxMap.put(i, standard[i]);
        }
        StringBuilder sb = new StringBuilder();
        if (k > n) {
            for (char c : arr) {
                sb.append(c);
            }
            int rst = k - n;
            while (rst > 0) {
                sb.append(standard[0]);
                rst--;
            }
            System.out.println(sb.toString());
        } else if (k < n) {
            int ik = k;
            while (k > 0 && map.get(arr[k - 1]) == m - 1) {
                k--;
            }
            for (int i = 0; i < k - 1; i++) {
                sb.append(arr[i]);
            }
            char cur = arr[k - 1];
            int innerIdx = 0;
            for (int i = 0; i < m; i++) {
                if (standard[i] == cur) {
                    innerIdx = i;
                    break;
                }
            }
            sb.append(standard[innerIdx + 1]);
            int curN = sb.length();
            while (curN < ik) {
                sb.append(standard[0]);
                curN++;
            }
            System.out.println(sb.toString());
        } else {
            int next = 0;
            int curIdx = 0;
            for (int i = n - 1; i >= 0; i--) {
                int cur = map.get(arr[i]);
                if (cur == m - 1) {
                    continue;
                }
                next  = cur + 1;
                curIdx = i;
                break;
            }
            for (int i = 0; i <= curIdx - 1; i++) {
                sb.append(arr[i]);
            }
            sb.append(idxMap.get(next));
            for (int i = curIdx + 1; i < n; i++) {
                sb.append(standard[0]);
            }
            System.out.println(sb.toString());
        }
    }
}
