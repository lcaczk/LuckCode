package com.wkk.simulation.pdd;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/14
 */
public class 多多的数字组合 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //每个数位各不相同且各个数位之和等于N——1+2+3+4+5+6+7+8+9 = 45，如果大于45一定会重复
        if(N > 45){
            System.out.println(-1);
            return;
        }
        //如果N<10，可以直接返回数字本身
        if(N < 10){
            System.out.println(N);
            return;
        }
        //右侧数位越大，越能保证左侧数位越小，越能保证整个数最小
        int nums = 0;
        int digit = 0;
        for (int i = 9; i >= 0; i--) {
            if (N >= i && N > 0) {
                N -= i;
                nums += i * (int)Math.pow(10, digit);
                digit++;
            }
        }
        System.out.println(nums);
    }

}
