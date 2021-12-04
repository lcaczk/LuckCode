package com.wkk.string;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author weikunkun
 * @since 2021/6/23
 */
public class LC_165 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        int[] arr = {1, 3, 4};
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            set.add(random.nextInt(100));
        }
        System.out.println(set);
    }

    public static int compareVersionI(String version1, String version2) {
        // 思路
        // 按照规则 进行字符串比较大小
        // 以每个. 作为分隔符 比较当前字符串的大小即可

        String[] fist = version1.split("\\.");
        String[] second = version2.split("\\.");
        int m = fist.length;
        int n = second.length;
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            int a = 0;
            int b = 0;
            if (i < m) {
                a = Integer.valueOf(fist[i]);
            }
            if (j < n) {
                b = Integer.valueOf(second[j]);
            }
            System.out.println(a + " " + b);
            if (a != b) {
                return a > b ? 1 : -1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        // 思路
        // 按照规则 进行字符串比较大小
        // 以每个. 作为分隔符 比较当前字符串的大小即可
        int m = version1.length();
        int n = version2.length();

        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            int a = 0;
            int b = 0;
            while (i < m && version1.charAt(i) != '.') {
                a = a * 10 + (version1.charAt(i) - '0');
                i++;
            }
            while (j < n && version2.charAt(j) != '.') {
                b = b * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (a != b) {
                if (a < b) {
                    return -1;
                }
                return 1;
            }
            // 过滤 .
            i++;
            j++;
        }
        return 0;
    }
}
