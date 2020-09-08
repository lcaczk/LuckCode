package com.wkk.everyday.sep;

import sun.jvm.hotspot.ui.action.HSDBActionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 题目：第k个排列
 *<p>
 *描述：给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *<p>
 *说明：n in [1, 9], k in [1, n!]
 *<p>
 *思路：回溯
 * @author kongwiki@163.com
 * @since 2020/9/5 3:29 下午
 */
public class PermutationSequence {
    private List<List<Integer>> res;
    private List<Integer> out;
    // 不出意外， 果断超时了
    // 自己的思路是吧所有的结果都存储起来，然后再获取结果
    public String getPermutation(int n, int k) {
        out = new ArrayList<>();
        res = new ArrayList<>();
        backtrack(res, out, n);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : res.get(k - 1)) {
            sb.append(integer);
        }
        return sb.toString();

    }

    public String getPermutationII(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }

    private void backtrack(List<List<Integer>> res, List<Integer> out, int n){
        if(out.size() == n){
            res.add(new ArrayList<>(out));
        }

        for (int i = 1; i <= n; i++) {
            if(out.contains(i)){
                continue;
            }
            out.add(i);
            backtrack(res, out, n);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {
        PermutationSequence sequence = new PermutationSequence();
        String permutation = sequence.getPermutation(9, 2678);
        System.out.println(permutation);
    }
}
