package com.wkk.everyday.july;

/**
 * @Time: 2020/7/8上午8:40
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DivingBoardLCCI {
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] res = new int[k+1];
        if(shorter == longer){
            int a = shorter * k;
            int[] b = new int[1];
            b[0] = a;
            return b;
        }
        else{
            for(int i =0; i<=k; i++){
                res[i] = shorter*i + longer*(k-i);
            }
            return res;
        }
    }
}
