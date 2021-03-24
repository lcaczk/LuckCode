package com.wkk.thread;

import java.util.function.IntConsumer;

/**
 * 1195 交替打印字符串
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *      如果这个数字可以被 3 整除，输出 "fizz"。
 *      如果这个数字可以被 5 整除，输出"buzz"。
 *      如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * @author weikunkun
 * @since 2021/3/24
 */
public class LC_1195 {
    private int n;
    private volatile int state = -1;

    public LC_1195(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if ( i % 15 == 0) {
                continue;
            }
            while (state != 3) {
                Thread.sleep(1);
            }
            printFizz.run();
            state = -1;
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if ( i % 15 == 0) {
                continue;
            }
            while (state != 5) {
                Thread.sleep(1);
            }
            printBuzz.run();
            state = -1;
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            while (state != 15) {
                Thread.sleep(1);
            }
            printFizzBuzz.run();
            state = -1;
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (state != -1) {
                Thread.sleep(1);
            }
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
            }
            else {
                if (i % 15 == 0) {
                    state = 15;
                } else if (i % 5 == 0) {
                    state = 5;
                } else {
                    state = 3;
                }
            }

        }
    }
}
