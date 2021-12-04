package com.wkk.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/22
 */
public class Offer_38 {
    List<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        int n = chs.length;
        boolean[] visited = new boolean[n];
        dfs(chs, n, 0, new LinkedList<>(), visited);
        return list.stream().toArray(String[]::new);
    }

    private void dfs(char[] chs, int n, int idx, Deque<Character> path, boolean[] visited) {
        if (path.size() == n) {
            StringBuilder sb = new StringBuilder();
            for (Character character : path) {
                sb.append(character);
            }
            list.add(sb.reverse().toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && chs[i-1] == chs[i] && visited[i-1] == false) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                path.push(chs[i]);
                dfs(chs, n, i + 1, path, visited);
                path.pop();
                visited[i] = false;
            }

        }
    }
}
