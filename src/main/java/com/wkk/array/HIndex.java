package com.wkk.array;

import java.util.Arrays;

/**
 * @Time: 20-3-30下午3:15
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class HIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i =1; i<citations.length; i++){
            if(i>=citations[i]){
                return i;
            }
        }
        return citations.length;
    }

    public static void main(String[] args) {
        int[] a = {3,0,6,1,5};
        int i = hIndex(a);
        System.out.println(i);
    }
}
