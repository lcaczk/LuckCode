package com.wkk.easy;

/**
 * @Time: 20-4-2上午8:58
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        boolean flag = true;
        if(n <= 0){
            return false;
        }
        while (n > 1){
            if(n % 3 != 0){
                flag = false;
                break;
            }
            n = n/3;

        }
        return flag;
    }
}
