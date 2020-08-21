package com.wkk.monotonicityStack;

/**
 * @Time: 2020/6/14下午8:44
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int len = arr.length, index = 0;
        int n = 0;
        while (n < 6){
            System.out.println(arr[index % len]);
            index++;
            n ++;
        }
    }
}
