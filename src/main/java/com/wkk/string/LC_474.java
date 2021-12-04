package com.wkk.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/6
 */
public class LC_474 {
    /**
     * 有问题
     */
    private static List<List<String>> res = new ArrayList<>();
    public static int findMaxForm(String[] strs, int m, int n) {
        // dfs
        dfs(strs, m, n, 0, new ArrayList<>());
        int count = 0;
        for (List<String> tmp : res) {
            count = Math.max(tmp.size(), count);
        }
        return count;
    }

    private static void dfs(String[] strs, int m, int n, int idx, List<String> list) {
        if (m < 0 || n < 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx > strs.length) {
            return;
        }
        for (int i = idx; i < strs.length; i++) {
            int one = countTarget(strs[i], '1');
            int zero = strs[i].length() - one;
            if (m - zero < 0 || n - one < 0) {
                continue;
            }
            list.add(strs[i]);
            dfs(strs, m - zero, n - one, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private static int countTarget(String str, char target) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == target) {
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        String[] arr = {"10", "0001", "111001", "1", "0"};
        findMaxForm(arr, 5, 3);
    }
}
