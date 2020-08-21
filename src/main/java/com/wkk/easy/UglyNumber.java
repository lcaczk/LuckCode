package com.wkk.easy;

/**
 * @Time: 20-3-24下午4:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        while (num%2 == 0) {
            num = num >> 1;
        }
        while (num%3 == 0){
            num = num/3;
        }
        while (num%5 == 0){
            num = num%5;
        }
        return num == 1;
    }
}
