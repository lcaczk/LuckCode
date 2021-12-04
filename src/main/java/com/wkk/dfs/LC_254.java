package com.wkk.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/7/17
 */
public class LC_254 {
    public List<List<Integer>> getFactors(int n) {
        return dfs(2, n);
    }

    /**
     * 大于等于 start 的 num 的因子组合
     * @param start
     * @param num
     * @return
     */
    public static List<List<Integer>> dfs(int start, int num) {
        if (num == 1) {
            return new ArrayList<>();
        }
        // C = A × B，则 A 和 B 一个小于等于根号 C，一个大于等于根号 C
        int qNum = (int) Math.sqrt(num);
        List<List<Integer>> result = new ArrayList<>();
        // 找出 [start, 根号num] 中，是 num 因子的数字
        for (int i = start; i <= qNum; i++) {
            if (num % i == 0) { // 找到一个因子
                List<Integer> simpleList = new ArrayList<>();
                simpleList.add(i);  // 小于或等于根号 num 的因子
                simpleList.add(num / i);    // 大于或等于根号 num 的因子
                result.add(simpleList); // 找到一对因子
                // 检查大于等于根号 num 的因子能怎么拆
                List<List<Integer>> nextLists = dfs(i, num / i);
                for (List<Integer> list : nextLists) {
                    list.add(i);    // list 的元素相乘是 num/i ，舔一个 i，相乘就是 num
                    result.add(list);
                }
            }
        }
        return result;
    }
}
