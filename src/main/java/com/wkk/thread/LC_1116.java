package com.wkk.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author weikunkun
 * @since 2021/3/24
 */
public class LC_1116 {
}

class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0) {
                odd.release();
            } else {
                even.acquire();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i < n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOddSync {
    private int n;
    private int i = 1;

    public ZeroEvenOddSync(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (i <= 2 * n && i % 2 == 0) wait();
                if (i > 2 * n) break;
                printNumber.accept(0);
                i++;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (i <= 2 * n && (i % 2 == 1 || (i % 2 == 0 && i / 2 % 2 == 1))) wait();
                if (i > 2 * n) break;
                printNumber.accept(i / 2);
                i++;
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (i <= 2 * n && (i % 2 == 1 || (i % 2 == 0 && i / 2 % 2 == 0))) wait();
                if (i > 2 * n) break;
                printNumber.accept(i / 2);
                i++;
                notifyAll();
            }
        }
    }
}