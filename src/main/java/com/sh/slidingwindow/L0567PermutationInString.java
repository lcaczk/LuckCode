package com.sh.slidingwindow;

/**
 * 题目：567.字符串的排列
 * 题目链接：https://leetcode-cn.com/problems/permutation-in-string/
 * <p>
 * 题目描述：
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * Related Topics 双指针 Sliding Window
 */
class L0567PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] needs = new int[26];
        // 不同字符数量
        int charUnique = 0;
        for (int i = 0; i < s1.length(); i++) {
            int cur = s1.charAt(i) - 'a';
            if (needs[cur] == 0) {
                charUnique++;
            }
            needs[cur]++;
        }

        int left = 0;
        int right = 0;
        int[] window = new int[26];
        // 记录已满足条件的字符数量
        int valid = 0;
        while (right < s2.length()) {
            int ch = s2.charAt(right) - 'a';
            right++;
            // 如果该字符需要
            if (needs[ch] > 0) {
                window[ch]++;
                // 该字符已经全部满足
                if (window[ch] == needs[ch]) {
                    valid++;
                }
            }

            // 窗口长度大于等于需要长度
            while (right - left >= s1.length()) {
                // 所有字符满足条件（字符个数相同），则返回true
                if (valid == charUnique) {
                    return true;
                }
                // 左边界移动
                int leftDel = s2.charAt(left) - 'a';
                left++;
                if (needs[leftDel] > 0) {
                    if (window[leftDel] == needs[leftDel]) {
                        valid--;
                    }
                    window[leftDel]--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L0567PermutationInString solution = new L0567PermutationInString();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
}