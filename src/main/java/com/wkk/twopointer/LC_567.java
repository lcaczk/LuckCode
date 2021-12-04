package com.wkk.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 * 1. 先将s1的数据 放入map中
 * 2. 然后使用来两个指针 在 s2进行滑动
 * 窗口大小固定 r - l + 1 == m
 * 未达到窗口大小时 在s2上再使用map存储遍历的元素及其数量 若是某个元素的数量已经达标 count + 1
 * 达到窗口大小时
 *     1. count == s1.length() 返回为true
 *     2. 进行窗口的移动 将 left + 1 若是 left 元素为s1中的某个元素，并且数量已经达标 count - 1
 * @author weikunkun
 * @since 2021/8/12
 */
public class LC_567 {
    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        Map<Character, Integer> cnt1 = new HashMap<>();
        for (char ch : chs1) {
            cnt1.put(ch, cnt1.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Character, Integer> cnt2 = new HashMap<>();
        while (right < n) {
            char ch = chs2[right];
            if (cnt1.containsKey(ch)) {
                cnt2.put(ch, cnt2.getOrDefault(ch, 0) + 1);
                if (cnt1.get(ch).equals(cnt2.get(ch))) {
                    count++;
                }
            }
            if (right - left + 1 == m) {  // 达到窗口固定大小
                if (count == cnt1.size()) {
                    return true;
                }
                char cur = chs2[left];
                if (cnt1.containsKey(cur)) {
                    if (cnt1.get(cur).equals(cnt2.get(cur))) {
                        count--;
                    }
                    cnt2.put(cur, cnt2.get(cur) - 1);
                }
                left++;
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "abcdxabcde";
        String b = "abcdeabcdx";
        System.out.println(checkInclusion(a, b));
    }
}
