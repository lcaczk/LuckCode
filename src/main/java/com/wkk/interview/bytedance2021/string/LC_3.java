package com.wkk.interview.bytedance2021.string;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 3 无重复字符串的长度
 * @author weikunkun
 * @since 2021/3/13
 */
public class LC_3 {
    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        // 思路
        Queue<Character> queue = new LinkedList<>();
        int len = s.length();
        int cur = 0;
        int max = 0;
        while (cur < len) {
            while (!queue.isEmpty() && queue.contains(s.charAt(cur))) {
                queue.poll();
            }
            queue.offer(s.charAt(cur));
            max = Math.max(max, queue.size());
            cur++;
        }
        return max;
    }
}
