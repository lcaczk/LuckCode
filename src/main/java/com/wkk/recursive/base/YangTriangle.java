package com.wkk.recursive.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角形
 * @author weikunkun
 * @since 2021/5/1
 */
public class YangTriangle {
    private int numRows;

    /**
     * 思路： 递归
     * 假定recursive方法可以实现该功能
     * 接下来就是递推关系的确定
     * 1. cur[i][j] = pre[i-1][j-1] + pre[i-1][j]
     * 接下来确定基础条件
     * 1. i = 0 的时候，为基础条件
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 0) {
            return res;
        }
        this.numRows = numRows;
        // 递归
        // 当前行依赖于上一行
        res.add(new ArrayList<>(Arrays.asList(1)));
        recution(res, 1, 0);
        return res;
    }

    private void recution(List<List<Integer>> res, int cur, int pre) {
        if (cur >= numRows) {
            return;
        }
        List<Integer> preList = res.get(pre);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= cur; i++) {
            if (i > 0 && i != cur) {
                int cal = preList.get(i-1) + preList.get(i);
                temp.add(cal);
            } else {
                temp.add(1);
            }
        }
        res.add(temp);
        recution(res, cur + 1, cur);
    }
}
