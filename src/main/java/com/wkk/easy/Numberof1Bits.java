package com.wkk.easy;

/**
 * @Time: 20-3-16下午7:59
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            count += n & 1;
            n = n >>>1;
        }
        return count;
    }


}
