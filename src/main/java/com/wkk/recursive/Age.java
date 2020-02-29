package com.wkk.recursive;

/**
 * @Time: 20-2-29上午10:10
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Age {
    public static int getAge(int year){
        if(year == 1996){
            return 0;
        }
        year -= 1;
        return getAge(year) + 1;
    }

    public static void main(String[] args) {
        int year = 2020;
        int age = getAge(2020);
        System.out.println("年龄为: " + age)
        ;
    }
}
