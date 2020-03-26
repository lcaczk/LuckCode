package com.wkk.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-25下午4:59
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Combinations {
    private static List<List<Integer>> lists = new LinkedList<>();

    // 回溯
    public static void dfs(int n, int k, List<Integer> track){
        if(track.size() == k){
            lists.add(new LinkedList<>(track));
        }
        for (int i = 1; i <= n; i++) {
            if (track.contains(i)) {
                continue;
            }
            track.add(i);
            dfs(n, k, track);
            track.remove(track.size()-1);
        }

    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int n = 3;
        dfs(n, 2, list);
        System.out.println(lists);
    }
}
