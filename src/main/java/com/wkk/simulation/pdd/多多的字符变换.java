package com.wkk.simulation.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/18
 */
public class 多多的字符变换 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int count = 0;
        scanner.nextLine();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        //将字符串转换为数组
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        //将两个字符串升序排列
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<len;i++){
            count += Math.abs(Integer.valueOf(a[i])-Integer.valueOf(b[i]));
        }
        System.out.println(count);
    }
}
