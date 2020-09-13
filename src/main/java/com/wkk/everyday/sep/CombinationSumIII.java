package com.wkk.everyday.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目： 组合总合III
 * <p>
 * 描述：
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 示例：
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 题解：
 * 回溯（这个月是回溯月没跑了）
 *
 * @author kongwiki@163.com
 * @since 2020/9/11 8:41 上午
 */
public class CombinationSumIII {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> out = new ArrayList<>();
        backtrack(1, out, k, n);
        return res;
    }

    private void backtrack(int start, List<Integer> out, int k, int n){
        if(out.size() == k && n == 0){
            res.add(new ArrayList<>(out));
            return;
        }
        for(int i = start; i <= n; i++){
            if(i >= 10){
                continue;
            }
            out.add(i);
            backtrack(i+1, out, k, n-i);
            out.remove(out.size()-1);
        }
    }
}
