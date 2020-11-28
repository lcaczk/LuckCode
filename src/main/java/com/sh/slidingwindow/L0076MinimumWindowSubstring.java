package com.sh.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：76.最小覆盖子串
 * 题目链接：https://leetcode-cn.com/problems/minimum-window-substring/
 * <p>
 * 题目描述：
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
 */
class L0076MinimumWindowSubstring {
    // 用map存储
    public String minWindow(String s, String t) {
        // 统计t中各字符次数
        Map<Character, Integer> needsMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needsMap.put(t.charAt(i), needsMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        String res = "";
        int left = 0;
        int right = 0;
        Map<Character, Integer> windowMap = new HashMap<>();

        // 记录目前有多少个字符
        int count = 0;
        // 记录最短需要多少个字符
        int minLength = s.length() + 1;
        while (right < s.length()) {
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
            // 新增一个满足条件的字符
            if (needsMap.getOrDefault(ch, 0) > 0 && needsMap.get(ch) >= windowMap.get(ch)) {
                count++;
            }
            // 找到全部字符，满足条件了，移动左边
            while (count == t.length()) {
                ch = s.charAt(left);
                // 移除最左边一个满足条件的字符（在t中）
                if (needsMap.getOrDefault(ch, 0) > 0 && needsMap.get(ch) >= windowMap.get(ch)) {
                    count--;
                }
                // 更新结果
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                windowMap.put(ch, windowMap.get(ch) - 1);
                left++;
            }
            right++;
        }

        return res;
    }

    // 用数组存储
    public String minWindow2(String s, String t) {
        // 统计t中各字符次数
        int[] needs = new int[128];
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        String res = "";
        int left = 0;
        int right = 0;
        int[] window = new int[128];

        // 记录目前有多少个字符
        int count = 0;
        // 记录最短需要多少个字符
        int minLength = s.length() + 1;
        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            // 新增一个满足条件的字符
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }
            // 找到全部字符，满足条件了，移动左边
            while (count == t.length()) {
                ch = s.charAt(left);
                // 移除最左边一个满足条件的字符（在t中）
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                // 更新结果
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                window[ch]--;
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        L0076MinimumWindowSubstring solution = new L0076MinimumWindowSubstring();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow2("ADOBECODEBANC", "ABC"));
    }
}