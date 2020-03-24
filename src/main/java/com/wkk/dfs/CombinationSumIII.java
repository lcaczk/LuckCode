package com.wkk.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-3-3下午7:49
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CombinationSumIII {
    private List<List<Integer>> results = new ArrayList<List<Integer>>();
    private List<Integer> out = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k>n){
            return results;
        }
        dfs(1, results, out, k, n);
        return results;
    }

    private void dfs(int start, List<List<Integer>> results, List<Integer> out, int k, int n){
        if(out.size() == k && n == 0){
            results.add(new ArrayList<Integer>(out));
            return;
        }
        for (int i = start; i <= n; i++) {
            if(i>=10){
                continue;
            }
            out.add(i);
            dfs(i+1, results, out, k, n-i);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 18;
        int k = 3;
        CombinationSumIII cc = new CombinationSumIII();
        List<List<Integer>> resutls = cc.combinationSum3(k, n);
        System.out.println(resutls);
    }
}
