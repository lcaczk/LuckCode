package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-3-26上午10:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PermutationSequence {
    private static List<String> results = new ArrayList<>();
    public static String getPermutation(int n, int k) {
        List<Integer> out = new ArrayList<>();
        backtrack(n, out);
        return results.get(k-1);
//        return results;
//        return results.get(k-1);

    }

    private static void backtrack(int n, List<Integer> out){
        if(out.size() == n){
            StringBuilder sb = new StringBuilder();
            for (Integer integer : out) {
                sb.append(integer);
            }
            results.add(sb.toString());
        }
        for (int i = 1; i <= n; i++) {
            if(out.contains(i)){
                continue;
            }
            out.add(i);
            backtrack(n, out);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(getPermutation(n, k));

    }
}
