package com.wkk.weekcompete;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/4/10
 */
public class LC_1487 {
    public static String[] getFolderNames(String[] names) {
        // 思路
        // 记录当前的最小
        // 通过set 判断内容是否存在
        Set<String> set = new HashSet<>();
        String[] res = new String[names.length];
        int k = 0;
        for (String name : names) {
            if (set.contains(name)) {
                int min = 1;
                String temp = name + "(" + min +")";
                while (set.contains(temp)) {
                    min += 1;
                    temp = name + "(" + min + ")";
                }
                res[k++] = temp;
                set.add(temp);
            } else {
                res[k++] = name;
            }
            set.add(name);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] names = {"kaido","kaido(1)","kaido","kaido(1)"};
        getFolderNames(names);
    }
}
