package com.wkk.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/4/20
 */
public class Test {
    private static Map<Character, Integer> map;
    public static String getSmallestString(int n, int k) {
        //不做校验了
        // 回溯，然后获取第一个字符串即可
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        String str = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 1; i <= str.length(); i++) {
            map.put(str.charAt(i-1), i);
        }
        backtrack(str, n, k, res, sb, 0);
        return res.size() > 0 ? res.get(0) : "";
    }

    private static void backtrack(String str, int n, int k, List<String> list, StringBuilder sb, int idx) {
        if (k == 0 && sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        if (k != 0 && sb.length()== n) {
            return;
        }
        for(int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtrack(str, n, k - map.get(str.charAt(i)), list, sb, i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
    }
}
