package com.wkk.top.twopointer;

/**
 * @Time: 2020/6/26上午10:49
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int low = 0;
        int height = (int) Math.sqrt(c);
        while (low < height){
            int sum = low*low + height * height;
            if(sum < c){
                low++;
            }else if(sum > c){
                height--;
            }else {
                return true;
            }
        }
        return false;
    }
}
