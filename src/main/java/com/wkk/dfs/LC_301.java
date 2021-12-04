package com.wkk.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除无效的括号
 * 暴力DFS
 * @author weikunkun
 * @since 2021/6/1
 */
public class LC_301 {
    int len;
    public List<String> removeInvalidParentheses(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 0;
        for (char c : cs) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                r++;
            }
        }
        int max = Math.min(l, r);
        Set<String> all = new HashSet<>();
        dfs(cs, 0, 0, max, "", all);
        List<String> ans = new ArrayList<>();
        for (String str : all) {
            if (str.length() == len) ans.add(str);
        }
        return ans;
    }
    /**
     * cs: 字符串 s 对应的字符数组
     * u: 当前决策到 cs 的哪一位
     * score: 当前决策方案的得分值（每往 cur 追加一个左括号进行 +1；每往 cur 追加一个右括号进行 -1）
     * max: 整个 dfs 过程的最大得分
     * cur: 当前决策方案
     * ans: 合法方案结果集
     */
    void dfs(char[] cs, int u, int score, int max, String cur, Set<String> ans) {
        if (u == cs.length) {
            if (score == 0 && cur.length() >= len) {
                len = Math.max(len, cur.length());
                ans.add(cur);
            }
            return;
        }
        if (cs[u] == '(') {
            if (score + 1 <= max) dfs(cs, u + 1, score + 1, max, cur + "(", ans);
            dfs(cs, u + 1, score, max, cur, ans);
        } else if (cs[u] == ')') {
            if (score > 0) dfs(cs, u + 1, score - 1, max, cur + ")", ans);
            dfs(cs, u + 1, score, max, cur, ans);
        } else {
            dfs(cs, u + 1, score, max, cur + String.valueOf(cs[u]), ans);
        }
    }
}
