package com.wkk;

/**
 * @author weikunkun
 * @since 2021/9/24
 */
public class D {

    public static void main(String[] args) {
        int da = (int)'代';
        int m = (int)'码';
        int w = (int)'w';
        int o = (int)'o';
        int r = (int)'r';
        int l = (int)'l';
        int d = (int)'d';
        System.out.println(Integer.toOctalString(242397));
        System.out.printf("%s = %d, 二进制: %s \n", "代", da, Integer.toBinaryString(da));
        System.out.printf("%s = %d, 二进制: %s \n", "码", m, Integer.toBinaryString(m));
        System.out.printf("%s = %d, 二进制: %s \n", "w", w, Integer.toBinaryString(w));
        System.out.printf("%s = %d, 二进制: %s \n", "o", o, Integer.toBinaryString(o));
        System.out.printf("%s = %d, 二进制: %s \n", "r", r, Integer.toBinaryString(r));
        System.out.printf("%s = %d, 二进制: %s \n", "l", l, Integer.toBinaryString(l));
        System.out.printf("%s = %d, 二进制: %s \n", "d", d, Integer.toBinaryString(d));
    }
}
