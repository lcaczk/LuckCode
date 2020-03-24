package com.wkk.easy;

/**
 * @Time: 20-3-24下午4:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        while (true){
            while (n != 0){
                if(n == 1){
                    return true;
                }
                if(n%2 != 0){
                    return false;
                }
                n = n/2;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        isPowerOfTwo(2);
    }
}
