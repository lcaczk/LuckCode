package com.wkk.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/10/4
 */
public class LC_482 {
    public static String licenseKeyFormattingII(String s, int k) {
        // 思路
        // 从后往前
        // 避免首部额外处理问题
        char[] arr = s.toCharArray();
        int n = arr.length;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(arr[i])) {
                continue;
            }
            if (idx == k) {
                sb.append("-");
                idx = 0;
            }
            sb.append(Character.toUpperCase(arr[i]));
            idx++;
        }
        return sb.reverse().toString();
    }

    public static String licenseKeyFormatting(String s, int k) {
        // 思路
        // 求余
        // 余数!= 0 余数作为开头第一组
        // 余数 == 0 整除，平均分配即可
        char[] arr = s.toCharArray();
        Deque<Character> queue = new ArrayDeque<>();
        for (char ch : arr) {
            if (Character.isLetterOrDigit(ch)) {
                queue.offer(Character.toUpperCase(ch));
            }
        }
        int n = queue.size();
        StringBuilder sb = new StringBuilder();
        if (n % k == 0) {
            if (queue.isEmpty()) {
                return "";
            }
            return genResult(queue, k, sb);
        }
        int rst = n % k;
        while (rst-- > 0) {
            sb.append(queue.poll());
        }
        sb.append("-");
        return genResult(queue, k, sb);

    }

    private static String genResult(Deque<Character> queue, int group, StringBuilder sb) {
        if (queue.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        StringBuilder tmp = new StringBuilder();
        int idx = 0;
        while (!queue.isEmpty()) {
            tmp.append(queue.poll());
            idx++;
            if (idx % group == 0) {
                sb.append(tmp);
                sb.append("-");
                tmp = new StringBuilder();
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "2-4-A0R-74K";
        System.out.println(licenseKeyFormatting(a, 3));
    }
}
