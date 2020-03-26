package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-3-26上午9:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CombinationSumIII {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n){
        List<Integer> out = new ArrayList<>();
        backtrack(1, out, n, k);
        return results;
    }

    private void backtrack(int start, List<Integer> out, int n, int k) {
        if(out.size() == k && n==0){
            results.add(new ArrayList<>(out));
        }
        for (int i = start; i <= n; i++) {
            if(i>=10){
                continue;
            }
            out.add(i);
            backtrack(i+1, out, n-i, k);
            out.remove(out.size()-1);
        }
    }
}
