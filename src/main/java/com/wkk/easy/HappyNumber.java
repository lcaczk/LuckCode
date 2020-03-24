package com.wkk.easy;

import java.util.HashSet;

/**
 * @Time: 20-3-24上午11:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if(n < 0){
            return false;
        }
        while (true){
            int sum = 0;
            while (n != 0){
                sum += Math.pow(n%10, 2);
                n = n/10;
            }
            if(sum/10 == 0){
                if(sum == 7 || sum ==1){
                    return true;
                }else {
                    return false;
                }
            }
            n = sum;
        }
    }

    public boolean isHappyII(int n){
        if(n < 0){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (n !=1){
            int sum = 0;
            while (n != 0){
                sum += Math.pow(n%10, 2);
                n = n/10;
            }
            set.add(n);
            if(set.contains(sum)){
                return false;
            }
            n = sum;
        }
        return true;
    }

}
