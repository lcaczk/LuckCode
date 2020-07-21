package com.wkk.multithread;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @Time: 2020/7/20下午3:44
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PrintThreeThread implements Runnable {
    private static int count = 0;
    private char[] ch = {'a', 'b', 'c'};

    @Override
    public void run() {
        while (true) {
            say();
        }
    }

    public synchronized void say() {
        System.out.println(ch[count % 3]);
        count++;
    }


    public static void main(String[] args) {
//        new Thread(new PrintThreeThread()).start();
//        new Thread(new PrintThreeThread()).start();
//        new Thread(new PrintThreeThread()).start();
        int gcd = gcd(16, 6);
        System.out.println(gcd);
    }

    public static int gcd(int a, int b) {
        // a > b;
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;

    }
}
