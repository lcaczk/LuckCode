package com.sh.slidingwindow;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：438.找到字符串中所有字母异位词
 * 题目链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * 题目描述：
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * Related Topics 哈希表
 */
class L0438FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        // p中各字符的次数
        int[] needs = new int[26];
        for (int i = 0; i < p.length(); i++) {
            needs[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new LinkedList<>();
        int left = 0;
        int right = 0;
        int[] window = new int[26];
        while (right < s.length()) {
            // 向右新增一个位置
            int ch = s.charAt(right) - 'a';
            window[ch]++;
            right++;
            // 左边界右移动
            while (window[ch] > needs[ch]) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            // 长度和p一样满足条件，记录位置
            if (right - left == p.length()) {
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L0438FindAllAnagramsInAString solution = new L0438FindAllAnagramsInAString();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
}
