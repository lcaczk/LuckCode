package com.wkk.easy;

/**
 * @Time: 20-4-2上午9:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        while ( num > 1 && num % 4 == 0){
            num /= 4;
        }
        return num == 1;
    }
}
