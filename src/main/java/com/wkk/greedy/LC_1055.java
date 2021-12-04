package com.wkk.greedy;

/**
 * 1055. 形成字符串的最短路径
 * @author weikunkun
 * @since 2021/7/14
 */
public class LC_1055 {
    public int shortestWay(String source, String target) {
        char[] src = source.toCharArray();
        char[] tgt = target.toCharArray();
        int start = 0;
        int ans = 0;
        int n = target.length();
        while (start < n) {
            int end = start;
            for (char ch : src) {
                if (ch == tgt[end]) {
                    end++;
                }
                if (end >= n) { // 避免超出
                    break;
                }
            }
            if (end == start) { // 说明有一个元素不存在
                return -1;
            }
            ans++;
            start = end;
        }
        return ans;
    }
}
