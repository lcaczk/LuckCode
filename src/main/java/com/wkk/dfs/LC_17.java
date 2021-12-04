package com.wkk.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对于字符串 ds 中的每一位数字，都有其对应的字母映射数组。
 *
 * 在 DFS 中决策每一位数字应该对应哪一个字母，
 * 当决策的位数 i == n，代表整个 ds 字符串都被决策完毕，将决策结果添加到结果集：
 * @author weikunkun
 * @since 2021/6/2
 */
public class LC_17 {
    Map<String, String[]> map = new HashMap<String, String[]>(){{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};
    List<String> ans;
    public List<String> letterCombinations(String ds) {
        int n = ds.length();
        ans = new ArrayList<>();
        if (n == 0) return ans;
        StringBuilder sb = new StringBuilder();
        // 1. 字符串
        // 2. 当前位置
        // 3. 总长度
        // 4. 临时变量
        // 5. 结果
        dfs(ds, 0, n, sb);
        return ans;
    }
    void dfs(String ds, int i, int n, StringBuilder sb) {
        if (i == n) {
            ans.add(sb.toString());
            return;
        }
        String key = ds.substring(i, i + 1);
        String[] all = map.get(key);
        for (String item : all) {
            sb.append(item);
            dfs(ds, i + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
