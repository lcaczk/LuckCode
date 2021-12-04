package com.wkk.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/2
 */
public class LC_22 {
    private List<String> res;
    private int n;
    // 1. 对于括号生成，必定是先左后右
    // 2. 左右括号数量等同
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs(0, n * 2, 0, n, "");
        return res;
    }
    // 1. 索引位置
    // 2. 字符串长度
    // 3. 分数 （ ： 1 ） ：-1
    // 4. 最大的得分值
    // 5. 路径
    private void dfs(int idx, int n, int score, int max, String path) {
        if (idx == n) {
            if (score == 0) {
                res.add(path);
            }
            return;
        }

        if (score + 1 <= max) { // 左括号
            dfs(idx + 1, n, score+ 1, max, path + "(");
        }
        if (score - 1 >= 0) { // 右括号
            dfs(idx + 1, n, score - 1, max, path + ")");
        }
    }
}
