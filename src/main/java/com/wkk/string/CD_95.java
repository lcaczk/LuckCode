package com.wkk.string;

import java.util.Scanner;

/**
 * 判断两个字符串是否为变形词
 * https://www.nowcoder.com/practice/b07c464a107e421ebbd2c82aebd42e39?tpId=101&&tqId=33163&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 * @author weikunkun
 * @since 2021/6/19
 */
public class CD_95 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str1 = sc.next();
        String str2 = sc.next();
        if (isDeformation(str1, str2) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    public static boolean isDeformation(String str1, String str2) {
        //优先考虑判空操作
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        //定义一个整形数组map，用于存储每一个字符出现的次数。
        int[] map = new int[256];//如果字符个数足够多，可以申请一个散列表。
        for (int i = 0; i < str1.length(); i++) {
            //map数组存储每一个字符出现的次数
            map[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            //如果map数组的值小于0，则返回false
            if (map[str2.charAt(i)]-- < 0) {
                return false;
            }
        }
        return true;
    }
}
