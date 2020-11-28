package com.sh.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：3.无重复字符的最长子串
 * 题目链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 题目描述：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * Related Topics 哈希表 双指针 字符串 Sliding Window
 */
class L0003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        // 窗口左右边界
        int left = 0;
        int right = 0;
        // 窗口内容，通过map判断是否重复
        Map<Character, Integer> windowMap = new HashMap<>();
        while (right < s.length()) {
            // 窗口右侧边界扩张
            char c = s.charAt(right);
            right++;
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            // 出现重复字符，窗口左侧边界收缩
            while (windowMap.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                windowMap.put(d, windowMap.get(d) - 1);
            }
            // 更新结果
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int start = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            // 出现重复字符
            if (map.containsKey(key)) {
                start = Math.max(map.get(key) + 1, start);
            }
            map.put(key, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        L0003LongestSubstringWithoutRepeatingCharacters solution = new L0003LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));

        System.out.println(solution.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring2("pwwkew"));
    }
}