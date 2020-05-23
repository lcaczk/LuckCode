package com.wkk.binarysearch;

/**
 * @Time: 2020/5/23下午8:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Sqrt_X {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int i = 1;
        int j = x / 2;
        while (i < j) {
            int mid = (i + j) / 2;
            if (mid < x / mid){
                // 下一轮搜索的区间是 [left, mid - 1]
                i = mid+1;
            }else {
                // 下一轮搜索的区间是 [mid, right]
                j = mid;
            }
        }
        return i;
    }
}
