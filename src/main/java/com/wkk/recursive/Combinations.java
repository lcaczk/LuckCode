package com.wkk.recursive;

import org.omg.CORBA.INTERNAL;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Time: 20-3-3上午10:15
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Combinations {
    static List<List<Integer>> results = new LinkedList<List<Integer>>();
    static List<Integer> out = new LinkedList<Integer>();
    public static List<List<Integer>> combine(int n, int k) {
        if(k>n){
            return results;
        }
        dfs(1, n, k, results, out);
        return  results;
    }

    private static void dfs(int cur, int n, int k, List<List<Integer>> lists, List<Integer> out){
        if(out.size() == k){
            // new 的原因为分开每一次的结果
            lists.add(new ArrayList<Integer>(out));
        }

        for (int i = cur; i <= n; i++) {
            // 以下为核心
            out.add(i);
            dfs(i+1, n, k, lists, out);
            out.remove(out.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        List<List<Integer>> combine = combine(n, k);
        System.out.println(combine);

//
//        List<List<Integer>> lists = new LinkedList<List<Integer>>();
//        List<Integer> list = new LinkedList<Integer>();
//        list.add(1);
//        list.add(2);
//        lists.add(list);
//
//        lists.add(list);
//        System.out.println(lists);
    }

}
