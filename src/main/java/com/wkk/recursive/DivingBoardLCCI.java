package com.wkk.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 2020/6/25下午1:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DivingBoardLCCI {
    // 超出时间限制
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] board = {shorter, longer};
        List<Integer> res = new ArrayList<>();
        backtrack(board, k, res, 0, 0, 0);
        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }

    private void backtrack(int[] board, int k, List<Integer> res, int time, int sum, int start) {
        if (time >= k) {
            res.add(sum);
            return;
        }
        for (int i = start; i < board.length; i++) {
            sum += board[i];
            backtrack(board, k , res, time+1, sum, i);
            sum -= board[i];
        }
    }

    

    public static void main(String[] args) {
        DivingBoardLCCI lcci = new DivingBoardLCCI();
        int[] ints = lcci.divingBoard(1, 2, 3);
        for (int anInt : ints) {
            System.out.print(anInt + " ") ;
        }
    }
}
