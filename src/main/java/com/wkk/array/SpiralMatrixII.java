package com.wkk.array;

/**
 * @author kongwiki@163.com
 * @since 2020/8/20下午11:29
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        //类似于剑指offer中的螺旋输出矩阵
        int[][] board = new int[n][n];
        int l = 0, t = 0;
        int r = n-1, b = n-1;
        int number = 1;
        while(true){
            for(int i=l; i<=r; i++){
                board[t][i] = number++;
            }
            if(++t > b){
                break;
            }
            for(int i = t; i<=b; i++){
                board[i][r] = number++;
            }
            if(--r < l){
                break;
            }
            for(int i = r; i>=l; i--){
                board[b][i] = number++;
            }
            if(--b < t){
                break;
            }
            for(int i = b; i>=t; i--){
                board[i][l] = number++;
            }
            if(++l > r){
                break;
            }
        }

        return board;
    }
}
