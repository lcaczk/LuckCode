package com.wkk.weekcompete;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 5742. 将句子排序
 * @author weikunkun
 * @since 2021/5/16
 */
public class SortSentence {
    public static String sortSentence(String s) {
        // 排序
        String[] strs = s.split(" ");
        int[] idx = new int[strs.length];
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int order = Integer.valueOf(str.substring(str.length() - 1));
            str = str.substring(0, str.length() -1);
            idx[i] = order;
            map.put(order, str);
        }
        // 排序
        Arrays.sort(idx);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx.length; i++) {
            sb.append(map.get(idx[i]));
            if (i != idx.length -1 ) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
        int a = 100;
    }
}
